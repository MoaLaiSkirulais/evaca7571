package evaca

import spock.lang.Shared
import spock.lang.Specification
import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

@TestFor(Oferta)
@Mock([Usuario, Raza, Categoria, Lote, Aviso, Plazo])
class OfertaSpec extends Specification {
	
	@Shared usuario;
	@Shared raza;
	@Shared categoria;
	@Shared plazo;
	@Shared lote;
	@Shared aviso;
	@Shared oferta;

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
		plazo = new Plazo(usuario: usuario, nombre: "Contado1")

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

		aviso = new Aviso(
			lote: lote, 
			consignatario: usuario, 
			precio: 3200
		)

		oferta = new Oferta(
			aviso: aviso, 
			usuario: usuario, 
			plazo: plazo,
			precio: 1000
		)
		
    }

    def cleanup() {
    }

    void "No se puede aceptar una oferta Pendiente"() {
		given:
			setup()

		when: 
			oferta.aceptar();
		
		then: 
			thrown DomainException

    }
	
	void "Se puede aceptar una oferta Activa"() {
		given:
			setup()
			usuario.tbTipo = 'Administrador'
			oferta.activar(usuario);
		
		when: 
			oferta.aceptar();
		
		then: 
			oferta.tbState == 'Aceptada'

    }
	
	void "Rechazar una oferta"() {
		given: "oferta activa"
			setup()
			usuario.tbTipo = 'Administrador'
			oferta.activar(usuario);

		when: "vendedor rechaza"
			oferta.rechazar();
		
		then: "oferta queda rechazada"
			oferta.tbState == 'Rechazada'

    }
}
