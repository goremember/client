package com.goremember.client.core.validation.result

import com.goremember.client.core.validation.failure.ValidationException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * This function uses contracts to imply that if the result is valid,
 * the receiver is of type [ValidationResult.Valid].
 *
 * @return `true` if this is a [ValidationResult.Valid], `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
public fun ValidationResult.isValid(): Boolean {
    contract {
        returns(true) implies (this@isValid is ValidationResult.Valid<*>)
        returns(false) implies (this@isValid is ValidationResult.Invalid)
    }

    return this is ValidationResult.Valid<*>
}

/**
 * This function uses contracts to imply that if the result is invalid,
 * the receiver is of type [ValidationResult.Invalid].
 *
 * @return `true` if this is a [ValidationResult.Invalid], `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
public fun ValidationResult.isInvalid(): Boolean {
    contract {
        returns(true) implies (this@isInvalid is ValidationResult.Invalid)
        returns(false) implies (this@isInvalid is ValidationResult.Valid<*>)
    }

    return this is ValidationResult.Invalid
}


/**
 * Retrieves the value of the validation result, casting it to the expected type.
 *
 * @param T The expected type of the result.
 * @return The result cast to the expected type.
 * @throws ValidationException if the validation result is not valid.
 * @throws ClassCastException if the type cast is invalid.
 */
@Suppress("UNCHECKED_CAST")
public fun <T> ValidationResult.getUnsafe(): T {
    return if (isValid()) {
        this as T
    } else {
        throw ValidationException(failures)
    }
}
