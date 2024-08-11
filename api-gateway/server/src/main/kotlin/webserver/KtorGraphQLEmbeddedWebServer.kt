package vault.manager.apiGateway.server.webserver

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.ktor.graphiQLRoute
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import vault.manager.apiGateway.server.ApplicationConfig
import vault.manager.apiGateway.server.WebServerConfig
import vault.manager.apiGateway.server.graphql.mutation.supportedMutations
import vault.manager.apiGateway.server.graphql.query.supportedQueries

internal object KtorGraphQLEmbeddedWebServer : WebServer {
    override fun run() {
        embeddedServer(
            Netty,
            host = WebServerConfig.HOST,
            port = WebServerConfig.PORT,
            module = Application::graphQLModule,
        ).start(wait = true)
    }
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
