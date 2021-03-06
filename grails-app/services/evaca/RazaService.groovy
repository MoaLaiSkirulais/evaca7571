package evaca

class RazaService {
	
	def mySessionService
	
	/* create */
	def create() {
		new Raza(usuario:mySessionService.usuario)
	}
	
	
	// /* create */
	// def create() {

		// [
			// raza: new Raza(usuario:mySessionService.usuario), 
			// razas: Raza.list()
		// ]
	// }
	
	
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
	
		/* viendolo ahora esto estaba pintado, es el AP ademas 
			ver si pasa al ctrl
			ah no, el usuario que venia del create, bueno no prob
		*/
	
		raza.save(flush:true, failOnError: false)
		if (raza.hasErrors()) {
			RazaException error = new RazaException()
			error.model = [raza: raza]
			throw error;
		}
		return raza
		
	}		
	
	
	/* search */
	def search() {
	
		def razas = Raza.list()
		return  [razas:razas]

	}		
	
	
}
