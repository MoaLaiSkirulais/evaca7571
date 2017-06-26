package evaca

import spock.lang.Shared
import spock.lang.Specification
import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

@TestFor(Aviso)
@Mock([])
class AvisoSpec extends Specification {

	@Shared usuario;
	@Shared raza;
	@Shared categoria;
	@Shared lote;
	@Shared aviso;

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

    }

    def cleanup() {
    }

    void "Crear un aviso"() {

		given:
			setup()

		when: 
			aviso = new Aviso(
				lote: lote, 
				consignatario: usuario, 
				precio: 3200
			).save()

		then: 
			aviso.validate()

    }

	
}
