package com.goremember.client.core.validation.rules

import com.goremember.client.core.validation.ValidationError
import com.goremember.client.core.validation.results.ValidationResult

public class RegexRule(
    private val regex: Regex
) : ValidationRule<String> {

    override fun validate(input: String): ValidationResult {
        return if (regex.containsMatchIn(input)) {
            ValidationResult.Success
        } else {
            ValidationResult.Failure(ValidationError.RegexError(regex))
        }
    }
}