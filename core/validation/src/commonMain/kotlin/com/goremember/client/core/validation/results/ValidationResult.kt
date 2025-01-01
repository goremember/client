package com.goremember.client.core.validation.results

import com.goremember.client.core.validation.CreationFailure
import kotlin.jvm.JvmInline

public sealed interface ValidationResult {
    public data object Valid : ValidationResult

    @JvmInline
    public value class Invalid(public val failure: CreationFailure) : ValidationResult
}