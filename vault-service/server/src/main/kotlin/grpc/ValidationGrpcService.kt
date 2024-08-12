package vault.manager.vaultService.server.grpc

import vault.manager.vaultService.server.proto.ValidationServiceGrpcKt.ValidationServiceCoroutineImplBase
import vault.manager.vaultService.server.proto.ValidationServiceOuterClass.ValidateRequest
import vault.manager.vaultService.server.proto.ValidationServiceOuterClass.ValidateResponse
import vault.manager.vaultService.server.proto.validateResponse

object ValidationGrpcService : ValidationServiceCoroutineImplBase() {
    override suspend fun validate(request: ValidateRequest): ValidateResponse =
        validateResponse {
            defects.addAll(emptyList())
        }
}
