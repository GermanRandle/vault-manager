package german.randle

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.operations.Query
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(
        Netty,
        port = 17999,
        host = "127.0.0.1",
        module = Application::module,
    ).start(wait = true)
}

fun Application.module() {
    install(GraphQL) {
        schema {
            packages = listOf("german.randle.schema")
            queries = listOf(TestQuery)
        }
    }
    routing {
        graphQLPostRoute()
    }
}

object TestQuery : Query {
    fun test() = "Test"
}
