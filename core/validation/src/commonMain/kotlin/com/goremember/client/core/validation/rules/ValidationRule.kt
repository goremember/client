package com.goremember.client.core.validation.rules

public typealias ValidationRule<T> = (T) -> Boolean

public fun regexRule(regex: Regex): ValidationRule<String> = { regex.containsMatchIn(it) }
public fun lengthMinRule(length: Int): ValidationRule<String> = { it.length > length }
public fun lengthMaxRule(length: Int): ValidationRule<String> = { it.length < length }