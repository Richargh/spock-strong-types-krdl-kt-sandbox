package de.richargh.sandbox.spock.strongtypes

import org.codehaus.groovy.runtime.StringGroovyMethods

class IntConversions {
    static final def convert = StringGroovyMethods.&asType

    static <T> Object asType(Integer self, Class<T> cls) {
        switch (cls) {
            case Integer.class:
                // This is a weird one.
                // I had to add this because otherwise calling `5 as Integer` produced an exception.
                // String does not need this though.
                return self
            case Age.class:
                return new Age(self)
            default:
                return convert(self, cls)
        }
    }
}
