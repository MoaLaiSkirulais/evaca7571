package evaca

class PlazoException extends RuntimeException {
	String message
	Map model
}

class PlazoService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		def model = [
			plazo: new Plazo([usuario:mySessionService.usuario])
		]

		[model: model]
	}



	/* edit */
	def edit(id) {

	    def model = [plazo: new Plazo().get(id)]
		return [model: model]
	}

	
	
	/* save */
	def save(Plazo plazo) {

		plazo.usuario = mySessionService.usuario
		plazo.save(flush:true)

		def model = [plazo: plazo]

		if (plazo.hasErrors()) {
			PlazoException error = new PlazoException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		

	

	/* search */
	def search() {

		def plazos = Plazo.list()
		return  [plazos:plazos]

	}		
	

	
	/* read */
	def read() {
	}	

	
}
