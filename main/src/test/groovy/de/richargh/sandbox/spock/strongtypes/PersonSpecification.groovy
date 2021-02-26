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

    def "a persons age can never be less than 0"() {
        given:
            Person person = person {
                it.withName(name)
                it.withAge(age)
                it.withJob(job)
            }
        when:
            person.changeAge(new Age(-1))
        then:
            thrown(IllegalArgumentException)
        where:
            name    | age   | job
            "John"  | 5     | "Reporter"
            "Lisa"  | 2     | "Astronaut"
    }

    def "all names are allowed"(Name name) {
        expect:
            person {it.withName(name) }

        where:
            theName  | _
            "John"   | _
            "Lisa"   | _

            name = theName as Name
    }

    @MakePerson
    def "all people are allowed"(Person person) {
        expect:
            person.name == new Name("John") || person.name == new Name("Lisa")
        where:
            name     | age
            "John"   | 5
            "Lisa"   | 20
    }

}