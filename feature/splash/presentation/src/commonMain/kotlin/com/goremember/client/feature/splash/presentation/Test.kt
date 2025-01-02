package com.goremember.client.feature.splash.presentation

import com.goremember.client.core.validation.Factory
import com.goremember.client.core.validation.rules.RegexRule
import com.goremember.client.core.validation.create
import com.goremember.client.core.validation.createOrThrow

data class Email(val value: String) {
    companion object {
        private val emailRegex = Regex("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")

        val factory: Factory<String, Email> = create(
            rules = listOf(
                RegexRule(emailRegex)
            ),
            constructor = ::Email
        )
    }
}

fun main() {
    val emailInput = "test@example.com"

    val result = Email.factory.createOrThrow(emailInput)
}
