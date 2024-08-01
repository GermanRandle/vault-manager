package vault.manager.apigateway.graphql

import com.expediagroup.graphql.server.operations.Query

object ValidateQuery : Query {
    fun validate(): ValidationResult = ValidationResult(emptyList())
}

data class ValidationResult(
    val defects: List<String>,
)
