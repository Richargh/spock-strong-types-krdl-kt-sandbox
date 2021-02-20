package de.richargh.sandbox.spock.strongtypes

data class PersonId(val rawValue: String): Identifier {

    override fun toString() = if (rawValue.length > 4)
        "${rawValue.subSequence(0, 4)}"
    else
        rawValue
}