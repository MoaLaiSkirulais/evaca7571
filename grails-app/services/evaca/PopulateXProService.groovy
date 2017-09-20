package evaca

import grails.transaction.Transactional
 
@Transactional
class PopulateXProService {
	
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
		administrador.state = UsuarioState.APROBADO
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

		def administrador = Usuario.findByUsername("administrador")
		def r = new ImageReader()
		
		/* lote1 */
		def lote1 = new Lote()
		lote1.raza = Raza.findByNombre("Braford")
		lote1.categoria = Categoria.findByNombre("Preñadas")
		lote1.provincia = "San Juan"
		lote1.ubicacion = "San Juan"
		lote1.image = r.readImageFile(LocalSystem.getDataResource("/mock/lotes/1 (1).jpg"))

		def productor1 = Usuario.findByUsername("productor1")
		productor1.postularLote(lote1)

		lote1.save(flush:true, failOnError: true)

		/* lote2 */
		/* hay que implementar el lote postular! */
		def lote2 = new Lote()
		lote2.raza = Raza.findByNombre("Jersey")
		lote2.categoria = Categoria.findByNombre("Preñadas")
		lote2.provincia = "La Rioja"
		lote2.ubicacion = "La Rioja"
		lote2.image = r.readImageFile(LocalSystem.getDataResource("/mock/lotes/1 (2).jpg"))
		
		def productor2 = Usuario.findByUsername("productor2")
		productor2.postularLote(lote2)

		lote2.save(flush:true, failOnError: true)

	}


	/* avisos */
	def avisos() {

		log.info "Populando avisos...";
		
		def administrador = Usuario.findByUsername("administrador")
		
		/* lote1 */
		L:{
			def propietario = Usuario.findByUsername("productor1")
			def lote = Lote.findByPropietario(propietario)
			lote.aviso.precio = 1000
			lote.aviso.plazo = Plazo.findByNombre("Contado")
			lote.aviso.consignatario = Usuario.findByUsername("consignatario")
			lote.aviso.postular(lote.propietario);
			lote.aviso.aprobar(administrador);
			lote.save(flush:true, failOnError: true)
		}
		
		/* lote2 */
		L:{
			def propietario = Usuario.findByUsername("productor2")
			def lote = Lote.findByPropietario(propietario)
			lote.aviso.precio = 1000
			lote.aviso.plazo = Plazo.findByNombre("Contado")
			lote.aviso.consignatario = Usuario.findByUsername("consignatario")
			lote.aviso.postular(lote.propietario);
			lote.aviso.aprobar(administrador);
			lote.save(flush:true, failOnError: true)
		}
	}


	/* _avisos */
	def _avisos() {

		log.info "Populando avisos..."
		
		def productor1 = Usuario.findByUsername("productor1")
		def administrador = Usuario.findByUsername("administrador")

		/* aviso1 */
		def aviso1 = new Aviso(propietario:productor1) /* aca podriamos empezar a usar algun factory interno tipo .create() */
		aviso1.lote = Lote.createCriteria().list () {raza{eq("nombre", "Braford")}}[0]
		aviso1.consignatario = Usuario.findByNombre("consignatario")
		aviso1.precio = 101
		aviso1.postular(productor1)
		aviso1.aprobar(administrador)

		/* aviso2 */
		def aviso2 = new Aviso(propietario:productor1)
		aviso2.lote = Lote.createCriteria().list () {raza{eq("nombre", "Jersey")}}[0]
		aviso2.consignatario = Usuario.findByNombre("consignatario")
		aviso2.precio = 102
		aviso2.postular(productor1)
		aviso2.aprobar(administrador)

		aviso1.save(flush:true, failOnError: true)
		aviso2.save(flush:true, failOnError: true)
	}


	/* ofertas */
	def ofertas() {

		log.info "Populando ofertas..."
		
		/* ofertar */
		def productor1 = Usuario.findByUsername("productor1")
		def oferta = new Oferta(propietario:productor1)
		oferta.aviso = Aviso.list()[0]
		oferta.plazo = Plazo.list()[1]
		oferta.precio = 1000
		oferta.postular(productor1)

		/* aprobar */
		def administrador = Usuario.findByUsername("administrador")
		oferta.aprobar(administrador)

		/* aceptar */		
		oferta.aceptar(productor1)		
		oferta.save(flush:true, failOnError: true)

	}


	/* resenas */
	def resenas() {

		log.info "Populando resenas..."
		def productor1 = Usuario.findByUsername("productor1")
		def venta = Venta.list()[0]

		def resena = new Resena(propietario:productor1)
		resena.prepare()
		resena.venta = venta
		resena.puntaje = 4
		
		/* preguntas */		
		resena.respuestas[0].puntaje = 5
		resena.respuestas[0].respuesta = "aceptable"
		
		resena.respuestas[1].puntaje = 3  /* seria bueno encadenar con setters aca alguna vez! */
		resena.respuestas[1].respuesta = "bueno"
		
		resena.respuestas[2].puntaje = 1
		resena.respuestas[2].respuesta = "esta bien"
		
		resena.respuestas[3].puntaje = 2
		resena.respuestas[3].respuesta = "tal vez"
		
		resena.respuestas[4].puntaje = 2
		resena.respuestas[4].respuesta = "sin comentarios"
		
		resena.postular(productor1)
		resena.save(flush:true, failOnError: true)

	}
	
	
	/* all */
	def all() {

		usuarios()
		razas()
		categorias()
		plazos()
		preguntas()
		lotes()
		avisos()
		ofertas()
		resenas()
		
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
