package vault.manager.apiGateway.server.graphql.query

import com.expediagroup.graphql.server.operations.Query
import vault.manager.apiGateway.server.graphql.model.GqlValidationResult
import vault.manager.apiGateway.server.graphql.model.toGql
import vault.manager.apiGateway.vaultServiceClient.inspectionServiceGrpcClient
import vault.manager.apiGateway.vaultServiceClient.proto.grpcValidateRequest

object ValidateGraphQLQuery : Query {
    @Suppress("unused")
    suspend fun validate(): GqlValidationResult = inspectionServiceGrpcClient.validate(grpcValidateRequest {}).toGql()
}
