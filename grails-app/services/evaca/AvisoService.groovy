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

		[
			aviso: new Aviso(), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]
	}

	
	/* edit */
	def edit(id) {
		
		def aviso = new Aviso().get(id)
		if (!aviso){
			throw new AvisoNotFoundException()
		}

		return aviso

	}


	/* publicar */
	def publicar(Aviso aviso) {	

		aviso.changeState(AvisoState.PUBLICADO, mySessionService.usuario)
		aviso.save(flush:true, failOnError: false)
		handleErrors(aviso)
	}


	/* rechazar */
	def rechazar(Aviso aviso) {

		aviso.changeState(AvisoState.RECHAZADO, mySessionService.usuario)
		aviso.save(flush:true, failOnError: true)
		handleErrors(aviso);
	}


	/* cancelar */
	def cancelar(Aviso aviso) {

		aviso.changeState(AvisoState.CANCELADO, mySessionService.usuario)
		/* liberar el lote */		
		aviso.save(flush:true, failOnError: true)
		handleErrors(aviso);
	}


	/* aprobar */
	def aprobar(Aviso aviso) {
	
		aviso.changeState(AvisoState.APROBACION, mySessionService.usuario)

		/* valida lote propio */
		if (aviso.propietario != aviso.lote.usuario){
			throw new DomainException(message : "El lote no pertenece al dueño del aviso")	
		}

		/* valida lote libre */
		if (aviso.lote.state != LoteState.DISPONIBLE){
			throw new DomainException(message : "El lote no está disponible")	
		}

		/* lockea lote */
		aviso.lote.state == LoteState.PUBLICADO

		/* save */
		aviso.save(flush:true, failOnError: true)
		handleErrors(aviso);	
		
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


	/* search */
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
