package evaca

class RazaException extends RuntimeException {
	String message
	Map model
}

class RazaService {
	
	def mySessionService
	
	/* create */
	def create() {
	
		def raza = new Raza()
		raza.usuario = mySessionService.usuario 

		def model = [
			raza: raza, 
			razas: Raza.list()
		]
		
		[model: model]
	}


	
	/* save */
	def save(Raza raza) {

		raza.usuario = mySessionService.usuario 
		raza.save(flush:true)

		def model = [
			raza: raza
		]

		if (raza.hasErrors()) {
			println "errores"
			RazaException error = new RazaException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		

	
	
	/* read */
	def read() {
	}	

	
}
