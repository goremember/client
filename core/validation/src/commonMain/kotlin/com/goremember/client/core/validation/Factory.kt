package com.goremember.client.core.validation

import com.goremember.client.core.validation.results.CreationResult
import com.goremember.client.core.validation.results.ValidationResult
import com.goremember.client.core.validation.results.getOrThrow
import com.goremember.client.core.validation.rules.ValidationRule

/**
 * Interface representing a factory that validates and creates values.
 *
 * @param T The type of the input to validate.
 * @param R The type of the created result.
 */
public interface Factory<T, R> {
    public val rules: List<ValidationRule<T>>

    /**
     * Validates and creates a result based on the given input.
     *
     * @param input the value to validate and process.
     * @return a [CreationResult] indicating success or failure.
     */
    public fun create(input: T): CreationResult
}

/**
 * Creates a factory that validates and creates values based on the given validation rules and constructor.
 *
 * @param rules the validation rules to apply.
 * @param constructor the function to create a result from input.
 * @return a new [Factory] instance.
 */
public fun <T, R> create(
    rules: List<ValidationRule<T>>,
    constructor: (T) -> R
): Factory<T, R> {
    return object : Factory<T, R> {
        override val rules: List<ValidationRule<T>> = rules

        override fun create(input: T): CreationResult {
            val errors = rules.mapNotNull { rule ->
                (rule.validate(input) as? ValidationResult.Failure)?.error
            }

            return if (errors.isEmpty()) {
                CreationResult.Success(constructor(input))
            } else {
                CreationResult.Failure(errors)
            }
        }
    }
}

/**
 * Creates a factory that creates values without validation rules.
 *
 * @param transform the function to create a result from input.
 * @return a new [Factory] instance.
 */
public fun <T, R> create(
    transform: (T) -> R
): Factory<T, R> {
    return object : Factory<T, R> {
        override val rules: List<ValidationRule<T>> = emptyList()

        override fun create(input: T): CreationResult {
            return CreationResult.Success(transform(input))
        }
    }
}

/**
 * Validates the input and returns the result or null if validation fails.
 *
 * @param input the value to validate.
 * @return the transformed value or null if validation fails.
 */
@Suppress("UNCHECKED_CAST")
public fun <T, R> Factory<T, R>.createOrNull(input: T): R? {
    return (create(input) as? CreationResult.Success<*>)?.value as R?
}

/**
 * Validates the input and returns the result or throws an exception if validation fails.
 *
 * @param input the value to validate.
 * @return the transformed value.
 * @throws CreationException if the result is a failure.
 */
@Suppress("UNCHECKED_CAST")
public fun <T, R> Factory<T, R>.createOrThrow(input: T): R {
    return create(input).getOrThrow()
}
