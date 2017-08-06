package evaca

class AvisoService {
	
	def mySessionService
	

	/* getConsignatarios */
	def getConsignatarios() {

		def consignatarios = Usuario.createCriteria().list () {
			eq("profile", UsuarioProfile.CONSIGNATARIO)
		}
		println consignatarios
		consignatarios
	}


	/* getLotes */
	def getLotes() {
		def lotes = Lote.createCriteria().list () { 
			eq("usuario", mySessionService.usuario)
		}
		lotes
	}


	/* create */
	def create() {
		new Aviso([propietario:mySessionService.usuario])
	}

	
	/* edit */
	def edit(id) {
		
		println "id: " + id
		def aviso = new Aviso().get(id)
		if (!aviso){
			throw new AvisoNotFoundException()
		}

		return aviso

	}


	/* aprobar */
	def aprobar(Long id) {	
	
		def aviso = new Aviso().get(id)
		if (!aviso){
			throw new AvisoNotFoundException();
		}

		aviso.changeState(AvisoState.APROBADO, mySessionService.usuario)
		aviso.save(flush:true, failOnError: false)
	}


	/* rechazar */
	def rechazar(Long id) {
	
		def aviso = new Aviso().get(id)
		if (!aviso){
			throw new AvisoNotFoundException();
		}

		aviso.changeState(AvisoState.RECHAZADO, mySessionService.usuario)
		aviso.save(flush:true, failOnError: false)
	}


	/* cancelar */
	def cancelar(Long id) {
	
		def aviso = new Aviso().get(id)
		if (!aviso){
			throw new AvisoNotFoundException();
		}

		aviso.changeState(AvisoState.CANCELADO, mySessionService.usuario)
		
		/* liberar el lote */
		aviso.lote.state = LoteState.DISPONIBLE				
		aviso.save(flush:true, failOnError: false)
	}


	/* postular */
	def postular(Aviso aviso) {
	
		/* fuerza el propietario al logged */
		aviso.propietario = mySessionService.usuario
		
		println "--> " + mySessionService.usuario
		aviso.changeState(AvisoState.POSTULADO, mySessionService.usuario)

		/* valida lote propio */
		if (aviso.propietario != aviso.lote?.usuario){
			throw new AvisoException(message : "El lote no pertenece al dueño del aviso")	
		}

		/* valida lote libre */
		if (aviso.lote?.state != LoteState.DISPONIBLE){
			throw new AvisoException(message : "El lote no está disponible")	
		}

		/* lockea lote */
		aviso.lote.state = LoteState.PUBLICADO

		/* save */
		aviso.save(flush:true, failOnError: false)
		if (aviso.hasErrors()) {
			throw new AvisoException()
		}
		
	}

	
	/* search */
	def search(params) {

		def avisos = Aviso.createCriteria().list () {

			// lote{usuario{eq("id", mySessionService?.usuario.id.toLong())}}
	
			if (params?.lote?.usuario?.id) {
				lote{usuario{eq("id", params.lote.usuario.id.toLong())}}
			}

			if (params?.consignatario?.id) {
				consignatario{eq("id", params.consignatario.id.toLong())}
			}

		}
		
		return avisos

	}


	/* handleErrors */
	def handleErrors(Aviso aviso) {

		if (aviso.hasErrors()) {

			def consignatarios = Usuario.createCriteria().list () {
				eq("profile", UsuarioProfile.CONSIGNATARIO)
			}

			AvisoException error = new AvisoException()
			error.model = [
				aviso: aviso, 
				consignatarios: consignatarios,
				lotes: Lote.list()
			]
			throw error;
		}
	}
	
}
