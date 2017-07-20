// http://themes.iamabdus.com/bigbag/1.2/list-panel.html#
// http://wrapbootstrap.com/preview/WB02DSN1B

package evaca

import grails.transaction.Transactional

@Transactional
class PopulateService {
	
	/* usuarios */
	def usuarios() {

		log.info "Populando usuarios..."

		def consignatario = new Usuario(
			username: "consignatario", 
			nombre: "consignatario", 
			apellido: "consignatario", 
			email: "consignatario@gmail.com", 
			profile: UsuarioProfile.CONSIGNATARIO, 
			comision: 11					
		)
		consignatario.password = ''
		consignatario.save()

		def productor = new Usuario(
			fechaCreacion: new Date(), 
			username: "productor", 
			nombre: "productor", 
			apellido: "productor", 
			email: "productor@gmail.com", 
			profile: UsuarioProfile.PRODUCTOR, 
			password: "", 
			comision: 11					
		)
		productor.password = ''
		productor.save()

		def administrador = new Usuario(
			fechaCreacion: new Date(), 
			username: "administrador", 
			nombre: "administrador", 
			apellido: "administrador", 
			email: "administrador@gmail.com", 
			profile: UsuarioProfile.ADMINISTRADOR, 
			password: "", 
			comision: 11					
		)
		administrador.password = ''
		administrador.save()

		return 1
	}
	
 
	/* razas */
	def razas() {

		log.info "Populando razas..."
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Aberdeen Angus").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Braford").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Holando Argentino").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Cruza").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Hereford").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Jersey").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Bovino Criollo").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Brangus").save()
		new Raza(usuario: Usuario.findByNombre("administrador"), nombre: "Careta").save()
		return 1
		}

	/* categorias */
	def categorias() {

		log.info "Populando categorias..."
		new Categoria(usuario: Usuario.findByNombre("administrador"), nombre: "Preñadas").save()
		new Categoria(usuario: Usuario.findByNombre("administrador"), nombre: "Con Ternero al Pie").save()
		new Categoria(usuario: Usuario.findByNombre("administrador"), nombre: "Vacias").save()
		new Categoria(usuario: Usuario.findByNombre("administrador"), nombre: "De Descarte").save()
		new Categoria(usuario: Usuario.findByNombre("administrador"), nombre: "Con Servicio").save()
		return 1
	}

	/* plazos */
	def plazos() {

		log.info "Populando plazos..."
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "Contado").save()
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "30 días").save()
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "30 y 60 días").save()
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "60 días").save()
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "30, 60 y 90 días").save()
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "90 días").save()
		new Plazo(usuario: Usuario.findByNombre("administrador"), nombre: "Otro").save()
		return 1
	}


	/* lotes */
	def lotes() {

		log.info "Populando lotes..."

		def lote1 = new Lote(
			usuario: Usuario.findByNombre("productor"), 
			raza: Raza.list()[2], 
			categoria: Categoria.list()[2], 
			tbState : LoteState.DISPONIBLE
		).save(flush:true, failOnError: true)
		
		def lote2 = new Lote(
			usuario: Usuario.findByNombre("productor"), 
			raza: Raza.list()[2], 
			categoria: Categoria.list()[2], 
			tbState : LoteState.DISPONIBLE
		).save(flush:true, failOnError: true)
		
		def lote3 = new Lote(
			usuario: Usuario.findByNombre("consignatario"), 
			raza: Raza.list()[2], 
			categoria: Categoria.list()[2], 
			tbState : LoteState.DISPONIBLE
		).save(flush:true, failOnError: true)
		
		def lote4 = new Lote(
			usuario: Usuario.findByNombre("productor"), 
			raza: Raza.list()[2], 
			categoria: Categoria.list()[2], 
			tbState : LoteState.DISPONIBLE
		).save(flush:true, failOnError: true)
		
		// new Lote(
			// usuario: Usuario.last(), 
			// raza: Raza.list()[1], 
			// categoria: Categoria.list()[1], 
			// fechaCreacion: new Date(), 
			// cantidad: 7, 
			// pesoPromedio: 440, 
			// pesoMaximo: 500, 
			// pesoMinimo: 350, 
			// trazada: true, 
			// ubicacion: "Lavalle, Buenos Aires", 
			// edad: 1, 
			// descarte: "", 
			// marcaLiquida: false, 
			// pesada: "", 
			// desbaste: "", 
			// cuit: "1-22344566-22", 
			// imagen: "http://i.imgur.com/u5Fcrfd.gif"
		// ).save()
		

		return 1
	}

	/* avisos */
	def avisos() {

		log.info "Populando avisos..."
		
		new Aviso(
			lote: Lote.list()[0], 
			consignatario: Usuario.findByNombre("productor"), 
			precio: 100
		).save()
		
		new Aviso(
			lote: Lote.list()[1], 
			consignatario: Usuario.findByNombre("productor"), 
			precio: 101
		).save()
		
		return
	}

	/* ofertas */
	def ofertas() {

		log.info "Populando ofertas..."
		
		new Oferta(
			aviso: Aviso.list()[0], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date(),
			plazo: Plazo.list()[1],
			precio: 1000
		).save()
		
		// new Oferta(
			// aviso: Aviso.list()[2], 
			// usuario: Usuario.list()[2], 
			// fechaCreacion: new Date(),
			// plazo: Plazo.list()[1],
			// precio: 1100
		// ).save()
		
		// new Oferta(
			// aviso: Aviso.list()[5], 
			// usuario: Usuario.list()[2], 
			// fechaCreacion: new Date(),
			// plazo: Plazo.list()[1],
			// precio: 1200
		// ).save()
		
		// new Oferta(
			// aviso: Aviso.list()[5], 
			// usuario: Usuario.list()[1], 
			// fechaCreacion: new Date(),
			// plazo: Plazo.list()[1],
			// precio: 1300
		// ).save()

		return
	}
	
	/* ventas */
	def ventas() {

		log.info "Populando ventas..."
		
		new Venta(
			oferta: Oferta.list()[0], 
			fechaCreacion: new Date()
		).save()

		// new Venta(
			// oferta: Oferta.list()[3], 
			// fechaCreacion: new Date()
		// ).save()

		// new Venta(
			// oferta: Oferta.list()[6], 
			// fechaCreacion: new Date()
		// ).save()

		return
	}	
	
	/* preguntas */
	def preguntas() {

		log.info "Populando preguntas..."
		
		new Pregunta( 						
			usuario: Usuario.list()[2], 
			label: "Como fue la comunicacion con el vendedor?"
		).save()

		new Pregunta( 			
			usuario: Usuario.list()[2],
			label: "Como fue la comunicacion con el consignatario?"
		).save()

		new Pregunta( 			
			usuario: Usuario.list()[2],
			label: "Cual es el estado del lote?"
		).save()

		new Pregunta( 			
			usuario: Usuario.list()[2],
			label: "Volveria a comprar?"
		).save()

		new Pregunta( 			
			usuario: Usuario.list()[2],
			label: "Que le parecio el sistema?"
		).save()

		return
	}
	
	/* resenas */
	def resenas() {

		log.info "Populando resenas..."
		
		new Resena( 
			puntaje:3,
			venta: Venta.list()[0], 
			usuario: Usuario.list()[2]
		).save(flush:true, failOnError: true)

		// new Resena( 
			// puntaje:5,
			// venta: Venta.list()[0], 
			// usuario: Usuario.list()[2]
		// ).save(flush:true, failOnError: true)

		// new Resena( 
			// puntaje:1,
			// venta: Venta.list()[0], 
			// usuario: Usuario.list()[2]
		// ).save(flush:true, failOnError: true)

		return
	}
	
	
	/* all */
	def all() {

		usuarios()
		razas()
		categorias()
		plazos()
		lotes()
		avisos()
		ofertas()
		ventas()
		preguntas()
		// resenas()
	}
	
	/* showAll */
	def showAll() {

		println Usuario.list().toString()
		println Raza.list().toString()
		println Categoria.list().toString()
		println Plazo.list().toString()
		println Lote.list().toString()
		println Aviso.list().toString()
		println Oferta.list().toString()
		println Venta.list().toString()
		println Resena.list().toString()
		println Pregunta.list().toString()
	}	
	
	/* countAll */
	def countAll() {

		println "Raza: " + Raza.list().size()
		println "Categoria: " + Categoria.list().size()
		println "Plazo: " + Plazo.list().size()
		println "Usuario: " + Usuario.list().size()
		println "Lote: " + Lote.list().size()
		println "Aviso: " + Aviso.list().size()
		println "Oferta: " + Oferta.list().size()
		println "Venta: " + Venta.list().size()
		println "Resena: " + Resena.list().size()
		println "Pregunta: " + Pregunta.list().size()

	}
	
	/* clearAll */
	def clearAll() {
	
		Resena.executeUpdate('delete from Resena')
		Oferta.executeUpdate('delete from Oferta')
		Venta.executeUpdate('delete from Venta')
		Aviso.executeUpdate('delete from Aviso')
		Lote.executeUpdate('delete from Lote')
		Plazo.executeUpdate('delete from Plazo')
		Raza.executeUpdate('delete from Raza')
		Categoria.executeUpdate('delete from Categoria')
		Pregunta.executeUpdate('delete from Pregunta')
		Usuario.executeUpdate('delete from Usuario')

		// Usuario.findAll().each { it.delete() }
		// Raza.findAll().each { it.delete() }
		// Categoria.findAll().each { it.delete() }
		// Plazo.findAll().each { it.delete() }
		// Usuario.findAll().each { it.delete() }
		// Lote.findAll().each { it.delete() }
		// Aviso.findAll().each { it.delete() }
		// Oferta.findAll().each { it.delete() }
		// Venta.findAll().each { it.delete() }
		// Resena.findAll().each { it.delete() }
		// Pregunta.findAll().each { it.delete() }

	}
}
