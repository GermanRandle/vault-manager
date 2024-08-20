package vault.manager.apiGateway.server.webserver

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.ktor.graphiQLRoute
import com.expediagroup.graphql.server.operations.Mutation
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import vault.manager.apiGateway.server.ApplicationConfig
import vault.manager.apiGateway.server.WebServerConfig
import vault.manager.apiGateway.server.graphql.query.ValidateGraphQLQuery

internal class KtorGraphQLEmbeddedWebServer(
    validateGraphQLQuery: ValidateGraphQLQuery,
) : WebServer {
    private val supportedQueries = listOf(
        validateGraphQLQuery,
    )

    private val supportedMutations = emptyList<Mutation>()

    override fun run() {
        embeddedServer(
            Netty,
            host = WebServerConfig.HOST,
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
