package german.randle

import io.ktor.server.application.Application
import io.ktor.server.application.call
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
}
