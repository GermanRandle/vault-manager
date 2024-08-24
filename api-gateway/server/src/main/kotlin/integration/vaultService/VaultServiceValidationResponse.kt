package vault.manager.apiGateway.server.integration.vaultService

import vault.manager.apiGateway.vaultServiceClient.proto.InspectionService

internal data class VaultServiceValidationResponse(
    val defects: List<String>,
)

internal fun InspectionService.GrpcValidateResponse.toVaultServiceResponse() =
    VaultServiceValidationResponse(
        defects = this.defectsList,
    )
