package de.richargh.sandbox.spock.strongtypes

import spock.lang.Specification

import static de.richargh.sandbox.spock.strongtypes.PersonBuilderKt.person

abstract class PeopleContractSpec extends Specification {
    protected abstract People testling()

    def "should be empty initially"(){
        expect:
        testling().all().isEmpty()
    }

    def "should contain the added elements"(){
        given:
        Person person = person { }
        when:
        testling().add(person)
        then:
        testling().all() contains person
    }

    def "should overwrite person when a person with the same id is added again"(){
        given:
        Person personOriginal = person { it.withId("1"); it.withName("John") }
        Person personUpdate = person { it.withId("1"); it.withName("Jack") }
        testling().add(personOriginal)
        when:
        testling().add(personUpdate)
        then:
        testling().all() contains personUpdate
    }
}
