package com.acme.app

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
 
 @TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "test something"() {
    }
	
	void 'test index'() {
        when:
        controller.index()

        then:
        response.redirectedUrl == '/simple/hello'
    }
	
	void "test hello"() {
        when:
        controller.hello()

        then:
        response.text == 'hello'
    }
	
	void 'test home'() {
        when:
        controller.home()

        then:
        view == '/simple/homePage'
        model.title == 'Hello World'
    }
}
