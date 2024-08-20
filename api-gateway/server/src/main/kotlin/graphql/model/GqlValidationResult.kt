package vault.manager.apiGateway.server.graphql.model

import vault.manager.apiGateway.server.integration.vaultService.VaultServiceValidationResult

data class GqlValidationResult(
    val defects: List<String>,
) {
    companion object {
        internal fun fromClient(validationResponse: VaultServiceValidationResult): GqlValidationResult =
            GqlValidationResult(defects = validationResponse.defects)
    }
}
