package vault.manager.apiGateway.server.graphql.model

import vault.manager.apiGateway.server.integration.vaultService.VaultServiceValidationResponse

data class GqlValidationResult(
    val defects: List<String>,
) {
    companion object {
        internal fun fromClientResponse(clientResponse: VaultServiceValidationResponse) =
            GqlValidationResult(
                defects = clientResponse.defects,
            )
    }
}
