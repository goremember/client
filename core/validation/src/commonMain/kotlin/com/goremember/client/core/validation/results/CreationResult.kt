package com.goremember.client.core.validation.results

import com.goremember.client.core.validation.CreationException
import com.goremember.client.core.validation.ValidationError
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents the result of a creation operation, either valid or invalid.
 */
public sealed interface CreationResult {

    /**
     * Represents a successful creation with a value of type [T].
     */
    public data class Success<T>(
        public val value: T
    ) : CreationResult

    /**
     * Represents a failed creation with a list of validation errors.
     */
    public data class Failure(
        public val errors: List<ValidationError>
    ) : CreationResult
}

/**
 * Checks if the creation result is successful.
 *
 * @return true if the result is [CreationResult.Success], otherwise false.
 */
@OptIn(ExperimentalContracts::class)
public fun CreationResult.isSuccessful(): Boolean {
    contract {
        returns(true) implies (this@isSuccessful is CreationResult.Success<*>)
        returns(false) implies (this@isSuccessful is CreationResult.Failure)
    }
    return this is CreationResult.Success<*>
}

/**
 * Checks if the creation result is a failure.
 *
 * @return true if the result is [CreationResult.Failure], otherwise false.
 */
@OptIn(ExperimentalContracts::class)
public fun CreationResult.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is CreationResult.Failure)
        returns(false) implies (this@isFailure is CreationResult.Success<*>)
    }
    return this is CreationResult.Failure
}

/**
 * Retrieves the value from a [CreationResult.Success] instance, or throws an exception if the result is [CreationResult.Failure].
 *
 * @return the value of type [T].
 * @throws CreationException if the result is a failure.
 */
@Suppress("UNCHECKED_CAST")
public fun <T> CreationResult.getOrThrow(): T {
    return when (this) {
        is CreationResult.Success<*> -> value as T
        is CreationResult.Failure -> throw CreationException(errors)
    }
}