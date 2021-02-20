package de.richargh.sandbox.spock.strongtypes

data class Person(
        override val id: PersonId,
        val name: Name,
        val age: Age,
        val job: Job)
    : Entity {

    fun changeAge(age: Age): Person {
        if (age < Age.Zero)
            throw IllegalArgumentException("Age must never be less than ${Age.Zero}")

        return copy(age = age)
    }
}