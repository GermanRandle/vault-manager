package vault.manager.apiGateway.server.graphql.model

import vault.manager.apiGateway.vaultServiceClient.proto.InspectionService.GrpcValidateResponse

data class GqlValidationResult(
    val defects: List<String>,
)

internal fun GrpcValidateResponse.toGql() =
    GqlValidationResult(
        defects = this.defectsList,
    )
