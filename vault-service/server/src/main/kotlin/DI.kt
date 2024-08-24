package vault.manager.vaultService.server

import vault.manager.vaultService.server.grpc.InspectionGrpcService
import vault.manager.vaultService.server.webserver.GrpcWebServer
import vault.manager.vaultService.server.webserver.WebServer

internal object DI {
    private val supportedGrpcServices = listOf(
        InspectionGrpcService,
    )

    val webServer: WebServer = GrpcWebServer(
        supportedGrpcServices,
    )
}

internal object WebServerConfig {
    const val PORT = 49153
}
