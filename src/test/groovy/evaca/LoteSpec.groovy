package evaca

import spock.lang.Shared
import spock.lang.Specification
import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

@TestFor(Lote)
@Mock([])
class LoteSpec extends Specification {
	
	@Shared usuario;
	@Shared raza;
	@Shared categoria;
	@Shared lote;

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

		raza = new Raza(usuario: usuario, nombre: "Aberdeen Angus1")
		categoria = new Categoria(usuario: usuario, nombre: "Preñadas1")

    }

    def cleanup() {
    }

    void "Crear un lote"() {
		given:
			setup()

		when: 
			lote = new Lote(
				usuario: usuario,  
				raza: raza, 
				categoria: categoria, 
				cantidad: 15, 
				pesoPromedio: 300, 
				pesoMaximo: 500, 
				pesoMinimo: 250, 
				trazada: true, 
				ubicacion: "San Justo, Santa Fe", 
				edad: 1, 
				descarte: "", 
				marcaLiquida: true, 
				pesada: "", 
				desbaste: "", 
				cuit: "1-22344566-22", 
				imagen: "http://i.imgur.com/hmo2zOp.gif"
			)

		then: 
			lote.validate()

    }

	
}
