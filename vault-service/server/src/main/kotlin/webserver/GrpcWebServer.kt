package vault.manager.vaultService.server.webserver

import io.grpc.ServerBuilder
import io.grpc.kotlin.AbstractCoroutineServerImpl
import vault.manager.vaultService.server.WebServerConfig
import java.io.IOException

internal class GrpcWebServer(
    private val supportedGrpcServices: List<AbstractCoroutineServerImpl>,
) : WebServer {
    override fun run() {
        val serverBuilder = ServerBuilder.forPort(WebServerConfig.PORT)

        supportedGrpcServices.forEach {
            serverBuilder.addService(it)
        }

        val server = serverBuilder.build()

        try {
            server.start()
        } catch (e: IOException) {
            throw WebServerException("Failed to start gRPC web server", e)
        }

        server.awaitTermination()
    }
}
