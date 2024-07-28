package vault.manager

import com.expediagroup.graphql.server.ktor.GraphQL
import com.expediagroup.graphql.server.ktor.graphQLPostRoute
import com.expediagroup.graphql.server.operations.Query
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.moduleAggregator() {
    restApiModule()
    graphQLModule()
}

private fun Application.restApiModule() {
    routing {
        get("/alive") {
            call.respondText("The API gateway is alive!")
        }
    }
}

private fun Application.graphQLModule() {
    install(GraphQL) {
        schema {
            packages = emptyList()
            queries = listOf(TestQuery)
        }
    }

    routing {
        graphQLPostRoute()
    }
}

/**
 * TODO: delete. For some reason, it works with [hello] method,
 * but I need some tool to see what it looks like in a browser.
 */
object TestQuery : Query {
    fun hello(): String = "hello"
}
