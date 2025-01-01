package com.goremember.client.core.validation.failure

public sealed class CreationFailure(
    public val message: String,
)  {
    public data class LengthMaxFailure(public val size: Int) : CreationFailure("Length must not be more than $size")
    public data class LengthMinFailure(public val size: Int) : CreationFailure("Length must not be less than $size")
    public data class RegexFailure(public val size: Int) : CreationFailure("Length must not be less than $size")

    public companion object {

        public fun ofMaxLength(size: Int): CreationFailure {
            return LengthMaxFailure(size)
        }

        public fun ofMinLength(size: Int): CreationFailure {
            return LengthMinFailure(size)
        }
    }
}