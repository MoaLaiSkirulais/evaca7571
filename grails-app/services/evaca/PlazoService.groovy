package evaca

class PlazoException extends RuntimeException {
	String message
	Map model
}

class PlazoService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}
		
		def model = [
			plazo: new Plazo([usuario:mySessionService.usuario])
		]

		[model: model]
	}

	
	
	/* save */
	def save(Plazo plazo) {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}

		plazo.usuario = mySessionService.usuario
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
