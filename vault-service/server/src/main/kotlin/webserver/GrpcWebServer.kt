package vault.manager.vaultService.server.webserver

import io.grpc.ServerBuilder
import io.grpc.kotlin.AbstractCoroutineServerImpl
import vault.manager.vaultService.server.WebServerConfig

internal class GrpcWebServer(
    private val supportedGrpcServices: List<AbstractCoroutineServerImpl>,
) : WebServer {
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
