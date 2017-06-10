package evaca

class PlazoException extends RuntimeException {
	String message
	Map model
}

class PlazoService {
	
	def sessionService
	
	/* create */
	def create() {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}
		
		def model = [
			plazo: new Plazo()
		]

		[model: model]
	}
	
	
	/* save */
	def save(Plazo plazo) {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}

		plazo.usuario = sessionService.usuario
		plazo.save(flush:true)

		def model = [
			plazo: plazo
		]

		if (plazo.hasErrors()) {
			PlazoException error = new PlazoException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	
	/* read */
	def read() {
	}	

	
}
