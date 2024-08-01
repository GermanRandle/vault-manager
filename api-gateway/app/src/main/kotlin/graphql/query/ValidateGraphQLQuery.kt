package vault.manager.apigateway.graphql.query

import com.expediagroup.graphql.server.operations.Query
import vault.manager.apigateway.graphql.model.GqlValidationResult

object ValidateGraphQLQuery : Query {
    fun validate(): GqlValidationResult = GqlValidationResult(emptyList())
}
