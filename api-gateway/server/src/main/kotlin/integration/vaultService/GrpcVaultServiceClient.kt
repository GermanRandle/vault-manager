package vault.manager.apiGateway.server.integration.vaultService

import io.grpc.StatusException
import vault.manager.apiGateway.server.integration.FailedGrpcClientCallException
import vault.manager.apiGateway.vaultServiceClient.inspectionServiceGrpcClient
import vault.manager.apiGateway.vaultServiceClient.proto.grpcValidateRequest

internal class GrpcVaultServiceClient : VaultServiceClient {
    override suspend fun validate(): Result<VaultServiceValidationResponse> {
        val grpcResponse = try {
            inspectionServiceGrpcClient.validate(grpcValidateRequest {})
        } catch (e: StatusException) {
            return Result.failure(
                FailedGrpcClientCallException(
                    methodName = "validate",
                    serviceName = "Vault Service",
                    cause = e,
                ),
            )
        }

        return Result.success(grpcResponse.toVaultServiceResponse())
    }
}
