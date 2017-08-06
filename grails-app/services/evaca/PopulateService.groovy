// http://themes.iamabdus.com/bigbag/1.2/list-panel.html#
// http://wrapbootstrap.com/preview/WB02DSN1B

package evaca

import grails.transaction.Transactional

@Transactional
class PopulateService {
	
	/* usuarios */
	def usuarios() {

		log.info "Populando usuarios..."

		/* consignatario */
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

		/* productor1 */
		def productor1 = new Usuario(
			fechaCreacion: new Date(), 
			username: "productor1", 
			nombre: "productor1", 
			apellido: "productor1", 
			email: "productor1@gmail.com", 
			profile: UsuarioProfile.PRODUCTOR, 
			password: "", 
			comision: 11					
		)
		productor1.password = ''
		productor1.save()		
		
		/* productor2 */
		def productor2 = new Usuario(
			fechaCreacion: new Date(), 
			username: "productor2", 
			nombre: "productor2", 
			apellido: "productor2", 
			email: "productor2@gmail.com", 
			profile: UsuarioProfile.PRODUCTOR, 
			password: "", 
			comision: 11					
		)
		productor2.password = ''
		productor2.save()
		
		/* administrador */
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
		
		/* permisos */
		productor1.changeState(UsuarioState.POSTULADO, administrador)
		productor1.changeState(UsuarioState.APROBADO, administrador)
		productor1.save(flush:true, failOnError: true)
		
		productor2.changeState(UsuarioState.POSTULADO, administrador)
		productor2.changeState(UsuarioState.APROBADO, administrador)
		productor2.save(flush:true, failOnError: true)

		consignatario.changeState(UsuarioState.POSTULADO, administrador)
		consignatario.changeState(UsuarioState.APROBADO, administrador)
		consignatario.save(flush:true, failOnError: true)

		administrador.changeState(UsuarioState.POSTULADO, administrador)
		administrador.changeState(UsuarioState.APROBADO, administrador)
		administrador.save(flush:true, failOnError: true)

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

		/* lote1 */
		def lote1 = new Lote(
			usuario: Usuario.findByNombre("productor1"), 
			raza: Raza.findByNombre("Braford"),
			categoria: Categoria.findByNombre("Preñadas")
		).save(flush:true, failOnError: true)
		
		/* lote2 */
		def lote2 = new Lote(
			usuario: Usuario.findByNombre("productor2"), 
			raza: Raza.findByNombre("Braford"),
			categoria: Categoria.findByNombre("Preñadas")
		).save(flush:true, failOnError: true)

		return 1
	}


	/* avisos */
	def avisos() {

		log.info "Populando avisos..."

		new Aviso(
			propietario: Usuario.findByNombre("productor1"), /* esto solo por ahora pq no puedo validar correspondecia quizas con un constraint? */
			lote: Lote.createCriteria().list () {usuario{eq("nombre", "productor1")}}, 
			consignatario: Usuario.findByNombre("consignatario"), 
			precio: 101
		).save(flush:true, failOnError: true)

		new Aviso(
			propietario: Usuario.findByNombre("productor2"), 
			lote: Lote.createCriteria().list () {usuario{eq("nombre", "productor2")}}, 
			consignatario: Usuario.findByNombre("consignatario"), 
			precio: 102
		).save(flush:true, failOnError: true)

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
