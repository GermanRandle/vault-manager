package vault.manager.apiGateway.server.graphql.query

import com.expediagroup.graphql.server.operations.Query
import vault.manager.apiGateway.server.graphql.model.GqlValidationResult
import vault.manager.apiGateway.server.graphql.model.toGql
import vault.manager.apiGateway.vaultServiceClient.proto.grpcValidateRequest
import vault.manager.apiGateway.vaultServiceClient.validationServiceGrpcClient

@Suppress("unused")
object ValidateGraphQLQuery : Query {
    suspend fun validate(): GqlValidationResult = validationServiceGrpcClient.validate(grpcValidateRequest {}).toGql()
}
