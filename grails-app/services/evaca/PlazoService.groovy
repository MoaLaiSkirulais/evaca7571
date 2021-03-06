package evaca

class PlazoService {
	
	def mySessionService
	
	/* create */
	def create() {
		new Plazo(usuario:mySessionService.usuario)
	}

	
	// /* create */
	// def create() {

		// [
			// plazo: new Plazo(usuario:mySessionService.usuario), 
			// plazos: Plazo.list()
		// ]
	// }
	
	
	/* edit */
	def edit(id) {
		def plazo = new Plazo().get(id)
		if (!plazo){
			throw new PlazoNotFoundException()
		}
		plazo
	}
	
	
	/* save */
	def save(Plazo plazo) {
	
		plazo.save(flush:true, failOnError: false)
		if (plazo.hasErrors()) {
			PlazoException error = new PlazoException()
			error.model = [plazo: plazo]
			throw error;
		}
		return plazo
		
	}		

	
	/* search */
	def search() {
	
		def plazos = Plazo.list()
		return plazos

	}			
	
	
}
