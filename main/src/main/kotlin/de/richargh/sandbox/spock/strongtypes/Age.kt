package de.richargh.sandbox.spock.strongtypes

data class Age(val rawValue: Int): Primitive, Comparable<Age> {

    override fun toString() = rawValue.toString()

    override fun compareTo(other: Age) = rawValue.compareTo(other.rawValue)

    companion object {

        @JvmStatic
        fun of(name: String) = Age(name.toInt())

        val Zero = Age(0)
    }
}