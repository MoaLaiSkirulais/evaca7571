package evaca

class RazaService {
	
	def mySessionService
	
	/* create */
	def create() {

		[
			raza: new Raza(usuario:mySessionService.usuario), 
			razas: Raza.list()
		]
	}
	
	
	/* edit */
	def edit(id) {
		def raza = new Raza().get(id)
		if (!raza){
			throw new RazaNotFoundException()
		}
		[raza: raza]
	}
	
	
	/* save */
	def save(Raza raza) {
	
		raza.save(flush:true, failOnError: false)
		if (raza.hasErrors()) {
			RazaException error = new RazaException()
			error.model = [raza: raza]
			throw error;
		}
		return raza
		
	}		
	
	
}
