package de.richargh.sandbox.spock.strongtypes

class InMemoryPeopleSpecification extends PeopleContractSpec {
    protected People testling = new InMemoryPeople()
    @Override protected People testling() { return testling }
}
