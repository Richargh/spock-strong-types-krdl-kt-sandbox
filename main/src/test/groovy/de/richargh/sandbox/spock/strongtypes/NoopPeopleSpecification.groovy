package de.richargh.sandbox.spock.strongtypes

// This test should fail, because NoopPeople does not match the contract
class NoopPeopleSpecification extends PeopleContractSpec {
    private People testling = new NoopPeople()

    @Override protected People testling() { return testling }
}
