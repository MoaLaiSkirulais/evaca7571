package evaca

class OfertaException extends RuntimeException {
	String message
	Map model
}

class OfertaService {
	
	def sessionService
	
	/* create */
	def create() {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}
		
		def oferta = new Oferta()
		oferta.usuario = sessionService.usuario
		
		def model = [
			oferta: oferta, 
			avisos: Aviso.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Oferta oferta) {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}

		oferta.usuario = sessionService.usuario
		oferta.save(flush:true)

		def model = [
			oferta: oferta
		]

		if (oferta.hasErrors()) {
			OfertaException error = new OfertaException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	
	
	/* read */
	def read() {
	}	

	
}
