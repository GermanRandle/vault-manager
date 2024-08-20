package vault.manager.apiGateway.server.integration.vaultService

internal interface VaultServiceClient {
    suspend fun validate(): VaultServiceValidationResult
}
