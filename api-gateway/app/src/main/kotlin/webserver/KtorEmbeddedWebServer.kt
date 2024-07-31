package vault.manager.webserver

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.ktor.graphiQLRoute
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import vault.manager.ApplicationConfig
import vault.manager.WebServerConfig
import vault.manager.graphql.ValidateQuery

object KtorEmbeddedWebServer : WebServer {
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
            packages = listOf(ApplicationConfig.GRAPHQL_MODELS_PACKAGE)
            queries = listOf(ValidateQuery)
            mutations = emptyList()
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
