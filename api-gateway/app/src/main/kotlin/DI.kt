package vault.manager.apigateway

import vault.manager.apigateway.webserver.KtorEmbeddedWebServer
import vault.manager.apigateway.webserver.WebServer

object DI {
    val webServer: WebServer = KtorEmbeddedWebServer
}
