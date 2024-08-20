package vault.manager.apiGateway.server.integration.vaultService

import vault.manager.apiGateway.vaultServiceClient.proto.InspectionService

internal data class VaultServiceValidationResult(
    val defects: List<String>,
) {
    companion object {
        fun fromGrpc(grpcValidationResult: InspectionService.GrpcValidateResponse) =
            VaultServiceValidationResult(
                defects = grpcValidationResult.defectsList,
            )
    }
}
