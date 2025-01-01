package com.goremember.client.feature.splash.presentation

import com.goremember.client.core.validation.factory.ValidationFactory
import com.goremember.client.core.validation.result.getUnsafe
import com.goremember.client.core.validation.result.isInvalid
import com.goremember.client.core.validation.result.isValid
import com.goremember.client.core.validation.rules.ValidationRule
import com.goremember.client.core.validation.rules.lengthMaxRule
import com.goremember.client.core.validation.rules.lengthMinRule
import com.goremember.client.core.validation.rules.regexRule

// TODO DELETE AND IMPLEMENTATION FROM THIS MODULE
@JvmInline
value class PhoneNumber private constructor(val string: String) {
    companion object : ValidationFactory<PhoneNumber, String> {
        override val rules: List<ValidationRule<String>> = listOf(
            regexRule(), lengthMaxRule(15), lengthMinRule(10)
        )
        override val constructor = ::PhoneNumber
    }
}

fun main() {
    val number = PhoneNumber.createOrNull("vadwwxz@gmail.com")
    if (number.isValid()) {
        number.getUnsafe<PhoneNumber>()
    }

    if(number.isInvalid()) {
        number.getUnsafe<PhoneNumber>()
    }
}