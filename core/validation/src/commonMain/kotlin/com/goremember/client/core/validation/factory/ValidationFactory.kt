package com.goremember.client.core.validation.factory

import com.goremember.client.core.validation.result.ValidationResult
import com.goremember.client.core.validation.result.getUnsafe
import com.goremember.client.core.validation.rules.ValidationRule

public interface ValidationFactory<T, V> {
    public val rules: List<ValidationRule<V>>
    public val constructor: (V) -> T

    public fun createOrNull(value: V): ValidationResult {
        val valid = rules.all { rule -> rule(value) }
        val result = constructor.invoke(value)

        return if (valid) {
            ValidationResult.Valid(result)
        } else {
            val failures = rules.filter { rule -> rule.invoke(value) != true }
            ValidationResult.Invalid(emptyList())
        }
    }

    public fun createOrThrow(value: V): T = createOrNull(value).getUnsafe<T>()
}