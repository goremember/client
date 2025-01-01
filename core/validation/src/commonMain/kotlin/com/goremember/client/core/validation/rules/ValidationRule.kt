package com.goremember.client.core.validation.rules

import com.goremember.client.core.validation.results.ValidationResult

/**
 * Defines a rule for validating an input value.
 *
 * @param Input The type of input that this rule validates.
 */
public interface ValidationRule<Input> {

    /**
     * Validates the provided value against this rule.
     *
     * @param value The input value to validate.
     * @return A [ValidationResult] indicating whether the validation was successful or not.
     */
    public fun validate(value: Input): ValidationResult

    public companion object
}
