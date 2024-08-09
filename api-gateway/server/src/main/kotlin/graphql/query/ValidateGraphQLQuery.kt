package vault.manager.apiGateway.server.graphql.query

import com.expediagroup.graphql.server.operations.Query
import vault.manager.apiGateway.server.graphql.model.GqlValidationResult

object ValidateGraphQLQuery : Query {
    fun validate(): GqlValidationResult = GqlValidationResult(emptyList())
}
