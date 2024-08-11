package vault.manager.vaultService.server

import io.grpc.ServerBuilder

object GrpcWebServer {
    fun run() {
        ServerBuilder.forPort(WebServerConfig.PORT)
            .addService(ValidationGrpcService)
            .build()
            .start()
            .awaitTermination()
    }
}
