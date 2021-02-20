package de.richargh.sandbox.spock.strongtypes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

abstract class PeopleContract(val testling: People) {

    @Test
    fun `should be empty initially`() {
        // arrange

        // act
        val result = testling.all()

        // assert
        assertThat(result).isEmpty()
    }

    @Test
    fun `should contain the added elements`() {
        // arrange
        val person = person { }

        // act
        testling.add(person)

        // assert
        assertThat(testling.all()).containsExactly(person)
    }

    @Test
    fun `should overwrite person when a person with the same id is added again`() {
        // arrange
        val person = person { withId("1"); withName("John") }
        val personUpdate = person { withId("1"); withName("Jack") }
        testling.add(person)

        // act
        testling.add(personUpdate)

        // assert
        assertThat(testling.all()).containsExactly(personUpdate)
    }
}