package evaca

/* OfertaService */
class OfertaService {
	
	def mySessionService
	
	/* getPlazos */
	def getPlazos() {

		// def consignatarios = Usuario.createCriteria().list () {
			// eq("profile", UsuarioProfile.CONSIGNATARIO)
		// }
		// consignatarios
		Plazo.list()
	}


	/* getAvisos */
	def getAvisos() {
		// def avisos = Aviso.createCriteria().list () { 
			// eq("usuario", mySessionService.usuario)
		// }
		Aviso.list()
	}
	
	
	/* create */
	def create() {		
		return new Oferta([propietario:mySessionService.usuario])
	}

	
	/* edit */
	def edit(id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException()
		}

		return oferta
	}
	
	
	/* setStateAprobacion */
	def setStateAprobacion(Oferta oferta) {
	
		/* fuerza al propietario del la oferta*/
		oferta.propietario = mySessionService.usuario
		
		/* ejecut el cambio de estado y sus validaciones */
		oferta.changeState(OfertaState.APROBACION, mySessionService.usuario)

		/* save */
		oferta.save(flush:true, failOnError: false)
		if (oferta.hasErrors()) {
			println "1" + oferta
			println oferta.id
			OfertaException error = new OfertaException()
			throw error;
		}
		
	}
	
	
	/* setStateAprobado */
	def setStateAprobado(Long id) {	
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.APROBADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}	

	
	/* setStateDesaprobado */
	def setStateDesaprobado(Long id) {	
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.DESAPROBADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}	

	
	/* setStateAceptado */
	def setStateAceptado(Long id) {	
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.ACEPTADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}	

	
	/* setStateRechazado */
	def setStateRechazado(Long id) {	
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.RECHAZADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}	

	
	/* setStateCancelado */
	def setStateCancelado(Long id) {	
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.CANCELADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}	

	
	/* search */
	def search() {		
		def ofertas = Oferta.list()
		return ofertas
	}	


	/* postular (oferente) */
	def postular(Oferta oferta) {
	
		/* fuerza el propietario al logged */
		oferta.propietario = mySessionService.usuario
		oferta.changeState(OfertaState.POSTULADO, mySessionService.usuario)

		/* valida aviso publicado */
		// if (aviso.lote?.state != LoteState.DISPONIBLE){
			// throw new AvisoException(message : "El lote no está disponible")	
		// }

		/* save */
		oferta.save(flush:true, failOnError: false)
		if (oferta.hasErrors()) {
			throw new OfertaException()
		}
		
	}
	

	/* cancelar (oferente) */
	def cancelar(Long id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.CANCELADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}
	

	/* aprobar (admin) */
	def aprobar(Long id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.APROBADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}
	

	/* desaprobar (admin) */
	def desaprobar(Long id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.DESAPROBADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}

	
	/* aceptar (vendedor) */
	def aceptar(Long id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.ACEPTADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}

	
	/* rechazar (vendedor) */
	def rechazar(Long id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException();
		}

		oferta.changeState(OfertaState.RECHAZADO, mySessionService.usuario)
		oferta.save(flush:true, failOnError: false)
	}

	
	/* changeState */
	def changeState(id, OfertaState newTbState) {

		def oferta = new Oferta().get(id)		
		if (!oferta){
			throw new OfertaNotFoundException()
		}

		oferta.changeState(newTbState, mySessionService.usuario)
		oferta.save(flush:true, failOnError: true)

    }
	
}
