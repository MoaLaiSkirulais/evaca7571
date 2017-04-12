package com.demo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Person)
class PersonSpec extends Specification {

    void "Test that name must begin with an upper case letter"() {
        when: 'the name begins with a lower letter'
        def p = new Person(name: 'jeff')

        then: 'validation should fail'
        !p.validate()

        when: 'the name begins with an upper case letter'
        p = new Person(name: 'Jeff')

        then: 'validation should pass'
        p.validate()
    }
}