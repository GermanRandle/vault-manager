package vault.manager.vaultService.server.webserver

import io.grpc.ServerBuilder
import vault.manager.vaultService.server.WebServerConfig
import vault.manager.vaultService.server.grpc.supportedGrpcServices

internal object GrpcWebServer : WebServer {
    override fun run() {
        val serverBuilder = ServerBuilder.forPort(WebServerConfig.PORT)

        supportedGrpcServices.forEach {
            serverBuilder.addService(it)
        }

        serverBuilder
            .build()
            .start()
            .awaitTermination()
    }
}
