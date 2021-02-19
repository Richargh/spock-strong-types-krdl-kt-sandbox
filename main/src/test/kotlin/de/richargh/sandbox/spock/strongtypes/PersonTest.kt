package de.richargh.sandbox.spock.strongtypes

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class PersonTest {

    @ParameterizedTest
    @CsvSource(value = ["John, 5, Reporter", "Lisa, 2, Astronaut"])
    fun `a persons age can never be less than 0`(
            name: Name, age: Age, job: Job) {
        // arrange
        val testling = Person(name, age, job)

        // act
        val thrown = catchThrowable { testling.changeAge(Age(-1)) }

        // assert
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["John", "Lisa"])
    fun `all names are allowed`(
            @ConvertWith(NamedPersonConverter::class) testling: Person) {
        // arrange

        // act
        val thrown = catchThrowable { testling.changeAge(Age(-1)) }

        // assert
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }
}