package com.goremember.client.core.validation.result

import com.goremember.client.core.validation.failure.CreationFailure

public sealed interface ValidationResult {
    public class Valid<T> internal constructor(
        public val value: T?
    ) : ValidationResult

    public class Invalid internal constructor(
        public val failures: List<CreationFailure>
    ) : ValidationResult
}