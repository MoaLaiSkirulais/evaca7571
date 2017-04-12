package com.demo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DemoController)
class DemoControllerSpec extends Specification {

    void 'Test an invalid number of items'() {
        when:
        params.numberOfItems = 42
        controller.addItems()

        then:
        response.text == 'something went wrong'
    }

    void 'Test a valid number of items'() {
        when:
        params.numberOfItems = 8
        controller.addItems()

        then:
        response.text == 'items have been added'
    }
}