package de.richargh.sandbox.spock.strongtypes

data class Name(val rawValue: String) {

    companion object {
        @JvmStatic
        fun of(name: String) = Name(name)
    }
}