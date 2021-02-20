package de.richargh.sandbox.spock.strongtypes

abstract class SealedEnum {

    override fun toString(): String = javaClass.simpleName
}