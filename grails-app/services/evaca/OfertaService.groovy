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


	/* search */
	def search() {		
		def ofertas = Oferta.list()
		return ofertas
	}	


	/* postular (oferente) */
	def postular(Oferta oferta) {
	
		/* fuerza el propietario al logged */
		oferta.propietario = mySessionService.usuario 
		/* esto se roba una oferta?! */
		/* analizar bien ahora! */
		oferta.changeState(OfertaState.POSTULADO, mySessionService.usuario)

		/* valida aviso publicado */
		if (oferta.aviso?.state != AvisoState.APROBADO){
			throw new OfertaException(message : "El aviso no está aprobado")	
		}

		/* solo oferta avisos ajenos */		
		if (oferta.aviso?.propietario == oferta.propietario){
			throw new OfertaStateFlowException(message: "No puede ofertar su propio aviso")
		}

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

		def venta = new Venta(
			oferta: oferta
		)
		// venta.save(flush:true, failOnError: false)

		// oferta.venta = venta
		// oferta.save(flush:true, failOnError: false)		

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
