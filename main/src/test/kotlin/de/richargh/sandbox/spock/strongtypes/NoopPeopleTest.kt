package de.richargh.sandbox.spock.strongtypes

// This test should fail, because NoopPeople does not match the contract
class NoopPeopleTest: PeopleContract(NoopPeople())