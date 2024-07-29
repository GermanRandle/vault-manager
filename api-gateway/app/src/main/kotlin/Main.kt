package vault.manager

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(
        Netty,
        port = PORT,
        host = HOST,
        module = Application::moduleAggregator,
    ).start(wait = true)
}

private const val HOST = "127.0.0.1"
private const val PORT = 17999
