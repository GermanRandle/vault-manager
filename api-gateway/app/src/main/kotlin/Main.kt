package vault.manager

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.ktor.graphiQLRoute
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import vault.manager.graphql.ValidateQuery

fun main() {
    embeddedServer(
        Netty,
        port = PORT,
        host = HOST,
        module = Application::graphQLModule,
    ).start(wait = true)
}

private fun Application.graphQLModule() {
    install(GraphQL) {
        schema {
            packages = listOf(GRAPHQL_MODELS_PACKAGE)
            queries = listOf(ValidateQuery)
            mutations = emptyList()
        }
    }

    routing {
        graphQLPostRoute(endpoint = GRAPHQL_ENDPOINT)
        graphiQLRoute(
            endpoint = ROOT_ENDPOINT,
            graphQLEndpoint = GRAPHQL_ENDPOINT,
        )
    }
}

private const val HOST = "127.0.0.1"
private const val PORT = 17999

private const val GRAPHQL_ENDPOINT = "graphql" // default
private const val ROOT_ENDPOINT = "/"

private const val GRAPHQL_MODELS_PACKAGE = "vault.manager.graphql"
