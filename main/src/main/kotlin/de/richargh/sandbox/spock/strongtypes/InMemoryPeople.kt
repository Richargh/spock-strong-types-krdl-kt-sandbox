package de.richargh.sandbox.spock.strongtypes

import java.util.concurrent.ConcurrentHashMap

class InMemoryPeople: People {

    private val entities = ConcurrentHashMap<PersonId, Person>()

    override fun toString(): String {
        return "${javaClass.simpleName}(${entities})"
    }

    override fun add(person: Person) {
        entities[person.id] = person
    }

    override fun all() = entities.values
}