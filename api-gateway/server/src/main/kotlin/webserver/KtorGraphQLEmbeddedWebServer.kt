package vault.manager.apiGateway.server.webserver

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.ktor.graphiQLRoute
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import graphql.GraphQLError
import graphql.execution.DataFetcherExceptionHandler
import graphql.execution.DataFetcherExceptionHandlerResult
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import vault.manager.apiGateway.server.ApplicationConfig
import vault.manager.apiGateway.server.WebServerConfig
import java.util.concurrent.CompletableFuture

internal class KtorGraphQLEmbeddedWebServer(
    private val supportedQueries: List<Query>,
    private val supportedMutations: List<Mutation>,
) : WebServer {
    override fun run() {
        embeddedServer(
            Netty,
            port = WebServerConfig.PORT,
            module = { graphQLModule() },
        ).start(wait = true)
    }

    private fun Application.graphQLModule() {
        install(GraphQL) {
            schema {
                packages = ApplicationConfig.graphQLSchemaDefinitionPackages
                queries = supportedQueries
                mutations = supportedMutations
            }

            engine {
                exceptionHandler = graphQLExceptionHandler
            }
        }

        routing {
            graphQLPostRoute(endpoint = WebServerConfig.GRAPHQL_ENDPOINT)
            graphiQLRoute(
                endpoint = WebServerConfig.ROOT_ENDPOINT,
                graphQLEndpoint = WebServerConfig.GRAPHQL_ENDPOINT,
            )
        }
    }
}

private val graphQLExceptionHandler = DataFetcherExceptionHandler {
    val graphQLError = GraphQLError.newError()
        .message(it.exception.toGraphQLErrorMessage())
        .location(it.sourceLocation)
        .path(it.path)
        .build()

    CompletableFuture.completedFuture(
        DataFetcherExceptionHandlerResult.newResult()
            .errors(listOf(graphQLError))
            .build(),
    )
}

private fun Throwable.toGraphQLErrorMessage(): String {
    val exception = this
    return buildString {
        append("${exception.javaClass.name}: $message")

        val causeHolder = cause
        if (causeHolder != null) {
            append(", CAUSED BY ${causeHolder.toGraphQLErrorMessage()}")
        }
    }
}
