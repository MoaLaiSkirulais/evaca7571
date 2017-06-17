package evaca

class PreguntaException extends RuntimeException {
	String message
	Map model
}

class PreguntaService {
	
	def mySessionService
	
	/* create */
	def create() {
	
		if (!mySessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}
		
		def model = [
			pregunta: new Pregunta(), 
			preguntas: Pregunta.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Pregunta pregunta) {
	
		if (!mySessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}

		pregunta.usuario = mySessionService.usuario //tal vez no sea necesario ya que viene del create 
		pregunta.save(flush:true)

		def model = [
			pregunta: pregunta
		]

		if (pregunta.hasErrors()) {
			println "errores"
			PreguntaException error = new PreguntaException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	
	
	/* read */
	def read() {
	}	

	
}
