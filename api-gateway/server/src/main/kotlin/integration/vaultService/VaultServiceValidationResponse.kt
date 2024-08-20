package vault.manager.apiGateway.server.integration.vaultService

import vault.manager.apiGateway.vaultServiceClient.proto.InspectionService

internal data class VaultServiceValidationResponse(
    val defects: List<String>,
) {
    companion object {
        fun fromGrpc(grpcValidationResult: InspectionService.GrpcValidateResponse) =
            VaultServiceValidationResponse(
                defects = grpcValidationResult.defectsList,
            )
    }
}
