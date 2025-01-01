package com.goremember.client.core.validation

/**
 * Represents a failure that occurs during the creation or validation process.
 *
 * @property message A descriptive message explaining the failure.
 */
public sealed class CreationFailure(
    public val message: String,
) {

    /**
     * A specific failure indicating that the input did not match the expected pattern.
     *
     * @property regex The regular expression that the input failed to match.
     */
    public data class PatternFailure(public val regex: Regex) : CreationFailure("Input should match $regex")

    public companion object {
        /**
         * Factory method to create a [PatternFailure].
         *
         * @param regex The regular expression that the input is expected to match.
         * @return A [PatternFailure] instance containing the provided regex.
         */
        public fun ofPattern(regex: Regex): CreationFailure {
            return PatternFailure(regex)
        }
    }
}