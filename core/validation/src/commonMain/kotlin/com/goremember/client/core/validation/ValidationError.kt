package com.goremember.client.core.validation

/**
 * Represents a validation error with a message describing the issue.
 *
 * @param message The error message that describes the validation issue.
 */
public open class ValidationError(
    public val message: String
) {
    public class RegexError(regex: Regex) : ValidationError("Does not match pattern: $regex")

    public companion object {
        public fun ofPattern(regex: Regex): RegexError = RegexError(regex)
    }
}
