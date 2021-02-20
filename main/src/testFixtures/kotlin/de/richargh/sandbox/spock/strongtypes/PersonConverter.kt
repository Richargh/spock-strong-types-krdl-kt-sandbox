package de.richargh.sandbox.spock.strongtypes

import org.junit.jupiter.params.converter.TypedArgumentConverter

class NameToPersonConverter:
        TypedArgumentConverter<String, Person>(String::class.java, Person::class.java) {

    override fun convert(source: String): Person {
        return person {
            withName(source)
        }
    }
}

