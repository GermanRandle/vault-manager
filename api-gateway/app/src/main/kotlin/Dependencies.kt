package vault.manager

import vault.manager.webserver.KtorEmbeddedWebServer
import vault.manager.webserver.WebServer

object DI {
    val webServer: WebServer = KtorEmbeddedWebServer
}
