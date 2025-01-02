package com.goremember.client.core.validation

/**
 * Exception thrown when a creation operation fails due to validation errors.
 *
 * @param errors A list of [ValidationError]s that caused the failure.
 */
public data class CreationException(
    val errors: List<ValidationError>,
) : Exception("Validation failed:\n${errors.joinToString("\n") { "- ${it.message}" }}")
