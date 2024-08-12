package vault.manager.vaultService.server

import vault.manager.vaultService.server.webserver.GrpcWebServer
import vault.manager.vaultService.server.webserver.WebServer

internal object DI {
    val webServer: WebServer = GrpcWebServer
}
