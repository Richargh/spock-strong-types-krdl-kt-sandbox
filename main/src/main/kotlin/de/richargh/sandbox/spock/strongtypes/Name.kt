package de.richargh.sandbox.spock.strongtypes

data class Name(val rawValue: String): Primitive {

    override fun toString() = rawValue

    companion object {
        @JvmStatic
        fun of(name: String) = Name(name)
    }
}