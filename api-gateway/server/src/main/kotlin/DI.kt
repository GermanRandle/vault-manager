package vault.manager.apiGateway.server

import vault.manager.apiGateway.server.webserver.KtorGraphQLEmbeddedWebServer
import vault.manager.apiGateway.server.webserver.WebServer

internal object DI {
    val webServer: WebServer = KtorGraphQLEmbeddedWebServer
}
