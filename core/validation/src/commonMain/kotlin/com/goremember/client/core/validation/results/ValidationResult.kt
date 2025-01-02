package com.goremember.client.core.validation.results

import com.goremember.client.core.validation.ValidationError

/**
 * Represents the result of a validation rule.
 */
public sealed interface ValidationResult {

    /**
     * Indicates a successful validation.
     */
    public object Success : ValidationResult

    /**
     * Indicates a failed validation with a specific [ValidationError].
     */
    public data class Failure(val error: ValidationError) : ValidationResult
}