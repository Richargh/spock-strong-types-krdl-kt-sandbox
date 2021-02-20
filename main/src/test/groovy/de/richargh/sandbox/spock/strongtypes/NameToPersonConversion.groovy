package de.richargh.sandbox.spock.strongtypes

import org.codehaus.groovy.runtime.StringGroovyMethods

import static de.richargh.sandbox.spock.strongtypes.PersonBuilderKt.person

class NameToPersonConversion {
    static final def convert = StringGroovyMethods.&asType

    static <T> Object asType(String self, Class<T> cls) {
        switch (cls) {
            case Person.class:
                return person { it.withName(self) }
            default:
                return convert(self, cls)
        }
    }
}
