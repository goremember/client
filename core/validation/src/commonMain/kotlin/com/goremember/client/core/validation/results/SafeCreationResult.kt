package com.goremember.client.core.validation.results

import com.goremember.client.core.validation.CreationFailure
import com.goremember.client.core.validation.ValidationException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents the result of a safe creation process, which can be either valid or invalid.
 *
 * @param TRaw The raw type of the input value.
 * @param TBoxed The type of the processed or "boxed" value.
 */
public sealed interface SafeCreationResult<out TRaw, out TBoxed> {
    /**
     * The raw input value associated with this result.
     */
    public val value: TRaw

    /**
     * Represents a successful creation result.
     *
     * @property value The raw input value.
     * @property boxed The processed or "boxed" value.
     */
    public class Valid<TRaw, TBoxed> internal constructor(
        public override val value: TRaw,
        public val boxed: TBoxed,
    ) : SafeCreationResult<TRaw, TBoxed>

    /**
     * Represents an unsuccessful creation result.
     *
     * @property value The raw input value.
     * @property failures A list of failures that occurred during the process.
     */
    public class Invalid<TRaw> internal constructor(
        public override val value: TRaw,
        public val failures: List<CreationFailure>,
    ) : SafeCreationResult<TRaw, Nothing> {
        /**
         * Creates an [Invalid] result with a single failure.
         *
         * @param value The raw input value.
         * @param failure The failure that occurred.
         */
        public constructor(value: TRaw, failure: CreationFailure) : this(value, listOf(failure))
    }
}

/**
 * Checks if the creation result is valid.
 *
 * @return `true` if the result is valid, otherwise `false`.
 */
@OptIn(ExperimentalContracts::class)
public fun SafeCreationResult<*, *>.isValid(): Boolean {
    contract {
        returns(true) implies (this@isValid is SafeCreationResult.Valid<*, *>)
        returns(false) implies (this@isValid is SafeCreationResult.Invalid<*>)
    }

    return this is SafeCreationResult.Valid
}

/**
 * Checks if the creation result is invalid.
 *
 * @return `true` if the result is invalid, otherwise `false`.
 */
@OptIn(ExperimentalContracts::class)
public fun SafeCreationResult<*, *>.isInvalid(): Boolean {
    contract {
        returns(true) implies (this@isInvalid is SafeCreationResult.Invalid<*>)
        returns(false) implies (this@isInvalid is SafeCreationResult.Valid<*, *>)
    }

    return this is SafeCreationResult.Invalid<*>
}

/**
 * Retrieves the boxed value from the result, throwing an exception if the result is invalid.
 *
 * @return The boxed value if the result is valid.
 * @throws ValidationException if the result is invalid.
 */
public fun <TRaw, TBoxed> SafeCreationResult<TRaw, TBoxed>.getUnsafe(): TBoxed {
    return if (isValid()) {
        @Suppress("UNCHECKED_CAST")
        boxed as TBoxed
    } else {
        throw ValidationException(failures)
    }
}

/**
 * Converts the creation result to a [Result] type.
 *
 * @return A [Result] containing the boxed value if valid, or an exception if invalid.
 */
public fun <TRaw, TBoxed> SafeCreationResult<TRaw, TBoxed>.toResult(): Result<TBoxed> = runCatching {
    getUnsafe()
}

/**
 * Retrieves the list of failures if the result is invalid, or an empty list if valid.
 */
public val SafeCreationResult<*, *>.failuresIfPresent: List<CreationFailure>
    get() {
        return if (this is SafeCreationResult.Invalid) failures else emptyList()
    }
