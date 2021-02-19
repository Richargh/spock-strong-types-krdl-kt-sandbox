package de.richargh.sandbox.spock.strongtypes

sealed class Job {
    object Reporter: Job()
    object Astronaut: Job()

    companion object {

        @JvmStatic
        fun of(value: String) =
                Job::class.sealedSubclasses.firstOrNull { it.simpleName == value }?.objectInstance
                ?: throw IllegalArgumentException("$value does not match any of the allowed subclasses")
    }
}