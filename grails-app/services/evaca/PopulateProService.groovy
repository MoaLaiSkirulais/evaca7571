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
		usuarioService.postular(consignatario)
		
		// def postular(PostularCommand cmd) {
		// try {

			// usuarioService.postular(cmd)

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
		usuarioService.postular(productor1)
		
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
		usuarioService.postular(productor2)
		
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
		usuarioService.postular(administrador)
		
		/* seteo admin, esto no es correcto directo */
		administrador.changeState(UsuarioState.APROBADO, administrador)
		administrador.save(flush:true, failOnError: false)
		
		/* permisos */
		mySessionService.login('administrador', '')		
		
		usuarioService.aprobar(productor1.id) /* quizas conviene pasarle el objeto */
		usuarioService.aprobar(productor2.id)
		usuarioService.aprobar(consignatario.id)

		return 1
	}


	/* razas */
	def razas() {

		log.info "Populando razas..."
		// mySessionService.login('administrador', '')

		def raza
		
		raza = razaService.create() /* como no puedo mandarle un contructor?! ahora lo dejo asi*/
		raza.nombre = "Aberdeen Angus"
		razaService.save(raza)
		
		raza = razaService.create()
		raza.nombre = "Braford"
		razaService.save(raza)
		
		raza = razaService.create() /* no deberia hacer falta el create? */
		raza.nombre = "Holando Argentino"
		razaService.save(raza)
		
		raza = razaService.create()
		raza.nombre = "Cruza"
		razaService.save(raza)
		
		raza = razaService.create()
		raza.nombre = "Hereford"
		razaService.save(raza)
		
		raza = razaService.create()
		raza.nombre = "Jersey"
		razaService.save(raza)
		
		raza = razaService.create()
		raza.nombre = "Bovino Criollo"
		razaService.save(raza)
		
		raza = razaService.create()
		raza.nombre = "Brangus"
		razaService.save(raza)
		
		raza = razaService.create()
 		raza.nombre = "Careta"
		razaService.save(raza)

	}


	/* categorias */
	def categorias() {

		log.info "Populando categorias..."
		
		def categoria
		
		categoria = categoriaService.create()
		categoria.nombre = "Preñadas"
		categoriaService.save(categoria)
		
		categoria = categoriaService.create()
		categoria.nombre = "Con Ternero al Pie"
		categoriaService.save(categoria)
		
		categoria = categoriaService.create()
		categoria.nombre = "Vacias"
		categoriaService.save(categoria)
		
		categoria = categoriaService.create()
		categoria.nombre = "De Descarte"
		categoriaService.save(categoria)
		
		categoria = categoriaService.create()
		categoria.nombre = "Con Servicio"
		categoriaService.save(categoria)

	}


	/* plazos */
	def plazos() {

		log.info "Populando plazos..."
		
		def plazo
				
		plazo = plazoService.create()
		plazo.nombre = "Contado"
		plazoService.save(plazo)
		
		plazo = plazoService.create()
		plazo.nombre = "30 días"
		plazoService.save(plazo)
		
		plazo = plazoService.create()
		plazo.nombre = "30 y 60 días"
		plazoService.save(plazo)
		
		plazo = plazoService.create()
		plazo.nombre = "60 días"
		plazoService.save(plazo)
		
		plazo = plazoService.create()
		plazo.nombre = "30, 60 y 90 días"
		plazoService.save(plazo)
		
		plazo = plazoService.create()
		plazo.nombre = "90 días"
		plazoService.save(plazo)
		
		plazo = plazoService.create()
		plazo.nombre = "Otro"
		plazoService.save(plazo)

	}


	/* preguntas */
	def preguntas() {

		log.info "Populando preguntas..."
		
		def pregunta

		pregunta = preguntaService.create()
		pregunta.label = "Como fue la comunicacion con el vendedor?"
		preguntaService.save(pregunta)		
		
		pregunta = preguntaService.create()
		pregunta.label = "Como fue la comunicacion con el consignatario?"
		preguntaService.save(pregunta)
		
		pregunta = preguntaService.create()
		pregunta.label = "Cual es el estado del lote?"
		preguntaService.save(pregunta)
		
		pregunta = preguntaService.create()
		pregunta.label = "Volveria a comprar?"
		preguntaService.save(pregunta)
		
		pregunta = preguntaService.create()
		pregunta.label = "Que le parecio el sistema?"
		preguntaService.save(pregunta)
		
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
