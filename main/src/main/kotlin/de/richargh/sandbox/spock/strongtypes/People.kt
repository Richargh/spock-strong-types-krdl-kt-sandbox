package de.richargh.sandbox.spock.strongtypes

interface People {
    fun add(person: Person)
    fun all(): Collection<Person>
}