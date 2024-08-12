package vault.manager.vaultService.server.grpc

import vault.manager.vaultService.server.proto.GrpcValidationServiceGrpcKt.GrpcValidationServiceCoroutineImplBase
import vault.manager.vaultService.server.proto.ValidationService.GrpcValidateRequest
import vault.manager.vaultService.server.proto.ValidationService.GrpcValidateResponse
import vault.manager.vaultService.server.proto.grpcValidateResponse

object ValidationGrpcService : GrpcValidationServiceCoroutineImplBase() {
    override suspend fun validate(request: GrpcValidateRequest): GrpcValidateResponse =
        grpcValidateResponse {
            defects.addAll(emptyList())
        }
}
