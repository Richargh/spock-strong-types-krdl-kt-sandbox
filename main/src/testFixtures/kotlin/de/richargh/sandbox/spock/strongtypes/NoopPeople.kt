package de.richargh.sandbox.spock.strongtypes

class NoopPeople: People {

    override fun add(person: Person) {
        // noop
    }

    override fun all(): Collection<Person> {
        return emptyList()
    }
}