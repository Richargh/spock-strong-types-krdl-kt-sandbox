package de.richargh.sandbox.spock.strongtypes

@Builder
class PersonBuilder {

    private var name = Name("John")
    private var age = Age(25)
    private var job: Job = Job.Astronaut

    fun build() = Person(
            name, age, job)

    fun withName(name: String) = withName(Name.of(name))
    fun withName(name: Name) = apply { this.name = name }

    fun withAge(age: Int) = withAge(Age(age))
    fun withAge(age: Age) = apply { this.age = age }

    fun withJob(job: String) = withJob(Job.of(job))
    fun withJob(job: Job) = apply { this.job = job }
}

fun person(init: PersonBuilder.() -> Unit) = PersonBuilder().apply(init).build()