package evaca

import spock.lang.Shared
import spock.lang.Specification
import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

@TestFor(Usuario)
@Mock([])
class UsuarioSpec extends Specification {
	
	@Shared usuario;

	def setup() {
		
		usuario = new Usuario(
			username: "mporto1", 
			nombre: "Martin", 
			apellido: "Porto", 
			email: "martinporto1@gmail.com", 
			tbTipo: "Productor", 
			password: "1234", 
			comision: 11					
		)

    }

    def cleanup() {
    }

    void "Crear un usuario duplicado"() {
		given:
		when: 
			domain.email = null
		
		then: 
			!domain.validate(['email'])
			domain.errors['email'].code == 'nullable'

    }
	
	// void "Crear un usuario duplicado"() {
		// given:
			// setup()

		// when: 
			// def usuario2 = new Usuario(
				// username: "mporto1", 
				// nombre: "Martin", 
				// apellido: "Porto", 
				// email: "martinporto1@gmail.com", 
				// tbTipo: "Productor", 
				// password: "1234", 
				// comision: 11					
			// )
		
		// then: 
			// thrown DomainException

    // }
	
}
