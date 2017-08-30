package evaca

import grails.transaction.Transactional
 
@Transactional
class PopulateProService {
	
	def mySessionService
	def usuarioService	
	def categoriaService
	def plazoService
	def razaService	
	def preguntaService	

	def loteService	
	def avisoService	
	def ofertaService	
	def resenaService
	
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
		consignatario.postular()

		/* productor1 */
		def productor1 = new Usuario(
			username: "productor1", 
			nombre: "productor1", 
			apellido: "productor1", 
			email: "productor1@gmail.com", 
			profile: UsuarioProfile.PRODUCTOR, 
			password: "", 
			comision: 11					
		)
		productor1.password = ''
		productor1.postular()
		
		/* productor2 */
		def productor2 = new Usuario(
			username: "productor2", 
			nombre: "productor2", 
			apellido: "productor2", 
			email: "productor2@gmail.com", 
			profile: UsuarioProfile.PRODUCTOR, 
			password: "", 
			comision: 11					
		)
		productor2.password = ''
		productor2.postular()
		
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
		administrador.postular()
		administrador.save(flush:true, failOnError: false)
		
		/* seteo admin, esto no es correcto directo */
		administrador.state == UsuarioState.APROBADO
		administrador.save(flush:true, failOnError: false)
		
		/* permisos */
		productor1.aprobar(administrador)
		productor2.aprobar(administrador)
		consignatario.aprobar(administrador)
		
		productor1.save(flush:true, failOnError: false)
		productor2.save(flush:true, failOnError: false)
		consignatario.save(flush:true, failOnError: false)
		administrador.save(flush:true, failOnError: false)

		return 1
	}


	/* razas */
	def razas() {

		log.info "Populando razas..."
		// mySessionService.login('administrador', '')

		def raza
		
		def administrador = Usuario.findByUsername("administrador")
		
		raza = new Raza(usuario:administrador) /* como no puedo mandarle un contructor?! ahora lo dejo asi*/
		raza.nombre = "Aberdeen Angus"
		raza.save(flush:true, failOnError: true) /* tal vez pasarle el creador para validar el permiso, con este nuevo esquema no lo veo mal */
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Braford"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Holando Argentino"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Cruza"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Hereford"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Jersey"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Bovino Criollo"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
		raza.nombre = "Brangus"
		raza.save(flush:true, failOnError: true)
		
		raza = new Raza(usuario:administrador) 
 		raza.nombre = "Careta"
		raza.save(flush:true, failOnError: true)
		
		/* no hay postular ni nada, es dificil validar integridad asi con dominio expuesto */

	}


	/* categorias */
	def categorias() {

		log.info "Populando categorias..."
		
		def administrador = Usuario.findByUsername("administrador")		

		new Categoria(usuario:administrador, nombre:"Preñadas")
			.save(flush:true, failOnError: true)
		
		new Categoria(usuario:administrador, nombre:"Con Ternero al Pie")
			.save(flush:true, failOnError: true)
		
		new Categoria(usuario:administrador, nombre:"Vacias")
			.save(flush:true, failOnError: true)
			
		new Categoria(usuario:administrador, nombre:"De Descarte")
			.save(flush:true, failOnError: true)
			
		new Categoria(usuario:administrador, nombre:"Con Servicio")
			.save(flush:true, failOnError: true)

	}


	/* plazos */
	def plazos() {

		log.info "Populando plazos..."
		
		def administrador = Usuario.findByUsername("administrador")			
				
		new Plazo(usuario:administrador, nombre:"Contado")
			.save(flush:true, failOnError: true)
			
		new Plazo(usuario:administrador, nombre:"30 días")
			.save(flush:true, failOnError: true)
			
		new Plazo(usuario:administrador, nombre:"30 y 60 días")
			.save(flush:true, failOnError: true)
			
		new Plazo(usuario:administrador, nombre:"60 días")
			.save(flush:true, failOnError: true)
			
		new Plazo(usuario:administrador, nombre:"30, 60 y 90 días")
			.save(flush:true, failOnError: true)
			
		new Plazo(usuario:administrador, nombre:"90 días")
			.save(flush:true, failOnError: true)
			
		new Plazo(usuario:administrador, nombre:"Otro")
			.save(flush:true, failOnError: true)

	}

 
	/* preguntas */
	def preguntas() {

		log.info "Populando preguntas..."
		
		def administrador = Usuario.findByUsername("administrador")			
		
		new Pregunta(usuario:administrador, label:"Como fue la comunicacion con el vendedor?")
			.save(flush:true, failOnError: true)

		new Pregunta(usuario:administrador, label:"Como fue la comunicacion con el consignatario?")
			.save(flush:true, failOnError: true)

		new Pregunta(usuario:administrador, label:"Cual es el estado del lote?")
			.save(flush:true, failOnError: true)

		new Pregunta(usuario:administrador, label:"Volveria a comprar?")
			.save(flush:true, failOnError: true)

		new Pregunta(usuario:administrador, label:"Que le parecio el sistema?")
			.save(flush:true, failOnError: true)
	
	}


	/* lotes */
	def lotes() {

		log.info "Populando lotes..."
		
		/* login */
		mySessionService.login('productor1', '')
		
		/* lote1 */
		def lote1 = loteService.create()
		lote1.raza = Raza.findByNombre("Braford")
		lote1.categoria = Categoria.findByNombre("Preñadas")
		loteService.save(lote1)

		/* lote2 */
		def lote2 = loteService.create()
		lote2.raza = Raza.findByNombre("Jersey")
		lote2.categoria = Categoria.findByNombre("Preñadas")
		loteService.save(lote2)

	}


	/* avisos */
	def avisos() {

		log.info "Populando avisos..."
		
		/* login */
		mySessionService.login('productor1', '')

		/* aviso1 */
		def aviso1 = avisoService.create()		 
		aviso1.lote = Lote.createCriteria().list () {raza{eq("nombre", "Braford")}}[0]
		aviso1.consignatario = Usuario.findByNombre("consignatario")
		aviso1.precio = 101
		avisoService.postular(aviso1)

		/* aviso2 */
		def aviso2 = avisoService.create()
		aviso2.lote = Lote.createCriteria().list () {raza{eq("nombre", "Jersey")}}[0]
		aviso2.consignatario = Usuario.findByNombre("consignatario")
		aviso2.precio = 102
		avisoService.postular(aviso2)
		
		/* login */
		mySessionService.login('administrador', '')

		avisoService.aprobar(aviso1.id)
		avisoService.aprobar(aviso2.id)
	}


	/* ofertas */
	def ofertas() {

		log.info "Populando ofertas..."
		
		/* login */
		mySessionService.login('productor2', '')

		/* ofertar */
		def oferta = ofertaService.create()
		oferta.aviso = Aviso.list()[0]
		oferta.plazo = Plazo.list()[1]
		oferta.precio = 1000
		ofertaService.postular(oferta)
		
		/* aprobar */
		mySessionService.login('administrador', '')
		ofertaService.aprobar(oferta.id)

		/* aceptar */		
		mySessionService.login('productor1', '')
		ofertaService.aceptar(oferta.id)

	}


	/* resenas */
	def resenas() {

		log.info "Populando resenas..."
		mySessionService.login('productor2', '')

		def resena = resenaService.create()
		resena.puntaje = 4
		resenaService.postular(resena)

	}
	
	
	/* all */
	def all() {

		usuarios()
		razas()
		categorias()
		plazos()
		preguntas()
		// lotes()
		// avisos()
		// ofertas()
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
		println "Respuesta: " + Respuesta.list().size()

	}


	/* clearAll */
	def clearAll() {
	
		Resena.executeUpdate('delete from Respuesta')
		Resena.executeUpdate('delete from Resena')
		Venta.executeUpdate('delete from Venta')
		Oferta.executeUpdate('delete from Oferta')
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
