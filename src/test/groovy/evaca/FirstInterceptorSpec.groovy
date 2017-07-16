package evaca


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(FirstInterceptor)
class FirstInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test first interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"first")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
