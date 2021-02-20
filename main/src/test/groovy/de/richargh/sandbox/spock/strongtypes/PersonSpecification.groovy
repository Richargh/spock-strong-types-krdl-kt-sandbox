package de.richargh.sandbox.spock.strongtypes

import spock.lang.Specification

import static de.richargh.sandbox.spock.strongtypes.PersonBuilderKt.person

class PersonSpecification extends Specification {
    def "a persons age can be changed"() {
        given:
            Person person = person {}
        when:
            person = person.changeAge(new Age(1))
        then:
            person.age == new Age(1)
    }
}