package de.richargh.sandbox.spock.strongtypes

import org.junit.jupiter.params.converter.ConvertWith

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@ConvertWith(NameToPersonConverter::class)
annotation class ConvertNameToPerson
