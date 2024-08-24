package vault.manager.apiGateway.server.graphql.model

import vault.manager.apiGateway.server.integration.vaultService.VaultServiceValidationResponse

data class GqlValidationResult(
    val defects: List<String>,
)

internal fun VaultServiceValidationResponse.toGql() =
    GqlValidationResult(
        defects = this.defects,
    )
