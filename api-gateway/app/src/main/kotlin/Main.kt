package vault.manager

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.ktor.graphiQLRoute
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing

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
            packages = emptyList()
            queries = listOf(GraphQLQueries)
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
