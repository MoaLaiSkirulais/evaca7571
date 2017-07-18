package evaca

class OfertaException extends RuntimeException {
	String message
	Map model
}

class OfertaService {
	
	def mySessionService
	
	/* create */
	def create() {
	
		def oferta = new Oferta()
		oferta.usuario = mySessionService.usuario

		def model = [
			oferta: oferta, 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Oferta oferta) {
	
		oferta.usuario = mySessionService.usuario
		oferta.save(flush:true)

		def model = [
			oferta: oferta, 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]

		if (oferta.hasErrors()) {
			OfertaException error = new OfertaException(message:"Errors!")
			error.model = model
			throw error;
		}

		/* crea la venta si es tbState=V */
		// println oferta.tbState
		
	}		
	
	/* changeState */
	def changeState(id, OfertaState newTbState) {

		def oferta = new Oferta().get(id)
		oferta.changeState(newTbState, mySessionService.usuario)
		oferta.save(flush:true, failOnError: true)

    }
	
}
