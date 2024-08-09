package vault.manager.apiGateway.server

import vault.manager.apiGateway.server.webserver.KtorEmbeddedWebServer
import vault.manager.apiGateway.server.webserver.WebServer

internal object DI {
    val webServer: WebServer = KtorEmbeddedWebServer
}
