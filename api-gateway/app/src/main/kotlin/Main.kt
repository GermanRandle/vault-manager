package vault.manager

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import vault.manager.moduleAggregator

fun main() {
    embeddedServer(
        Netty,
        port = 17999,
        host = "127.0.0.1",
        module = Application::moduleAggregator,
    ).start(wait = true)
}
