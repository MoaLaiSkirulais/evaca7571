package com.demo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

@TestMixin(GrailsUnitTestMixin)
class MyCommandObjectSpec extends Specification {

    void 'Test that numberOfItems must be between 1 and 10'() {
        when: 'numberOfItems is less than 1'
        def co = new MyCommandObject()
        co.numberOfItems = 0

        then: 'validation fails'
        !co.validate()
        co.hasErrors()
        co.errors['numberOfItems'].code == 'range.toosmall'

        when: 'numberOfItems is greater than 10'
        co.numberOfItems = 11

        then: 'validation fails'
        !co.validate()
        co.hasErrors()
        co.errors['numberOfItems'].code == 'range.toobig'

        when: 'numberOfItems is greater than 1'
        co.numberOfItems = 1

        then: 'validation succeeds'
        co.validate()
        !co.hasErrors()

        when: 'numberOfItems is greater than 10'
        co.numberOfItems = 10

        then: 'validation succeeds'
        co.validate()
        !co.hasErrors()
    }
}