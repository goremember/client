package com.goremember.client.feature.splash.presentation

import com.goremember.client.core.validation.factory.CreationFactory
import com.goremember.client.core.validation.result.CreationResult
import com.goremember.client.core.validation.factory.factory
import com.goremember.client.core.validation.rules.MaxLengthValidationRule
import com.goremember.client.core.validation.rules.MinLengthValidationRule
import com.goremember.client.core.validation.rules.RegexValidationRule
import com.goremember.client.core.validation.rules.ValidationRule

// TODO DELETE AND IMPLEMENTATION FROM THIS MODULE
@JvmInline
value class PhoneNumber private constructor(val string: String) {
    companion object {
        @JvmStatic
        val REGEX = ""

        @JvmStatic
        val factory: CreationFactory<PhoneNumber, String> = factory(
            rules = listOf(
                RegexValidationRule(Regex.fromLiteral(REGEX)),
                MaxLengthValidationRule(15),
                MinLengthValidationRule(8),
            ),
            constructor = ::PhoneNumber
        )
    }
}

fun main() {
    val number = PhoneNumber.factory.createSafe("+380977854850")
}