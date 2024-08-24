package vault.manager.apiGateway.server.graphql.query

import com.expediagroup.graphql.server.operations.Query
import vault.manager.apiGateway.server.graphql.model.GqlValidationResult
import vault.manager.apiGateway.server.graphql.model.toGql
import vault.manager.apiGateway.server.integration.vaultService.VaultServiceClient

class ValidateGraphQLQuery internal constructor(
    private val vaultServiceClient: VaultServiceClient,
) : Query {
    suspend fun validate(): GqlValidationResult =
        vaultServiceClient.validate().fold(
            onSuccess = { it.toGql() },
            onFailure = { throw it },
        )
}
