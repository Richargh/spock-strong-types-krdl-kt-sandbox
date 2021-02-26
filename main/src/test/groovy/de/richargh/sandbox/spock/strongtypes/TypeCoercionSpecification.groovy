package de.richargh.sandbox.spock.strongtypes

import spock.lang.Specification

class TypeCoercionSpecification extends Specification {
    /*
     * Note that we added the *To*Conversion via resources/META-INF.
     * We could've also added it explicitly in the setup-Method of our tests: String.mixin(*To*Conversion)
     */

    def "String can be cast to Person via type coercion"(){
        when:
            Person person = "John" as Person
        then:
            person.name == new Name("John")
    }

    def "String can be cast to Name via type coercion"(){
        when:
            Name name = "John" as Name
        then:
            name == new Name("John")
    }

    def "Int can be cast to Age via type coercion"(){
        when:
            Age age = 5 as Age
        then:
            age == new Age(5)
    }
}