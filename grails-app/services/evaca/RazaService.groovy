package evaca

class RazaService {
	
	def sessionService
	
	/* create */
	def create() {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}
		
		def model = [
			raza: new Raza(), 
			razas: Raza.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Raza raza) {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}

		raza.usuario = sessionService.usuario //tal vez no sea necesario ya que viene del create 
		raza.save(flush:true)

		def model = [
			raza: raza
		]

		if (raza.hasErrors()) {
			UserRegistrationException error = new UserRegistrationException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	
	
	/* read */
	def read() {
	}	

	
}
