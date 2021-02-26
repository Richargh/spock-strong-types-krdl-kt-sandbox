package de.richargh.sandbox.spock.strongtypes

import org.codehaus.groovy.runtime.StringGroovyMethods

import static de.richargh.sandbox.spock.strongtypes.PersonBuilderKt.person

class StringConversions {
    static final def convert = StringGroovyMethods.&asType

    static <T> Object asType(String self, Class<T> cls) {
        switch (cls) {
            case Name.class:
                return Name.of(self)
            case Person.class:
                return person { it.withName(self) }
            default:
                return convert(self, cls)
        }
    }
}
