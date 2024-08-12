package vault.manager.apiGateway.server.graphql.model

import vault.manager.apiGateway.vaultServiceClient.proto.ValidationServiceOuterClass.ValidateResponse

data class GqlValidationResult(
    val defects: List<String>,
)

internal fun ValidateResponse.toGql() =
    GqlValidationResult(
        defects = this.defectsList,
    )
