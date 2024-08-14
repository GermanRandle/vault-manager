package vault.manager.vaultService.server.grpc

import vault.manager.vaultService.server.proto.GrpcInspectionServiceGrpcKt.GrpcInspectionServiceCoroutineImplBase
import vault.manager.vaultService.server.proto.InspectionService.GrpcValidateRequest
import vault.manager.vaultService.server.proto.InspectionService.GrpcValidateResponse
import vault.manager.vaultService.server.proto.grpcValidateResponse

object InspectionGrpcService : GrpcInspectionServiceCoroutineImplBase() {
    override suspend fun validate(request: GrpcValidateRequest): GrpcValidateResponse =
        grpcValidateResponse {
            defects.addAll(emptyList())
        }
}
