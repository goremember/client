package com.goremember.client.core.validation.rules

import com.goremember.client.core.validation.results.ValidationResult

/**
 * Interface for validating input of type [T].
 *
 * @param T The type of the input.
 */
public interface ValidationRule<T> {

    /**
     * Validates the input.
     *
     * @param input The input to validate.
     * @return A [ValidationResult] indicating the validation outcome.
     */
    public fun validate(input: T): ValidationResult
}