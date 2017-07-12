package evaca

class AvisoService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		if (!mySessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged to perform this action")
		}

		def model = [
			lote: new Aviso(), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]

		[model: model]
	}

	
	/* edit */
	def edit(id) {

		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be logged to perform this action")
		}
	    
	    def model = [
			aviso: new Aviso().get(id), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]
		return [model: model]
	}
	
	
	/* save */
	def save(Aviso aviso) {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be logged to perform this action")
		}

		aviso.save(flush:true)

		def model = [
			aviso: aviso, 
			avisos: Aviso.list(),
			categorias: Categoria.list(),
			razas: Raza.list()
		]

		if (aviso.hasErrors()) {
			DomainException error = new DomainException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	

	/* search */
	def search() {
	
		// if (!mySessionService.isAdministrator()) {
			// throw new UserRegistrationException(message:"You must be Admin to perform this action")
		// }

		// def lotes = Lote.list()
		// return [lotes:lotes]

	}
	
}
