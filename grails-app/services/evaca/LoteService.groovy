package evaca

class LoteService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		if (!mySessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged to perform this action")
		}

		def model = [
			lote: new Lote([usuario:mySessionService.usuario]), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]

		[model: model]
	}

	
	/* edit */
	def edit(id) {

		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be logged to perform this action")
		}
	    
		def model = [
			lote: new Lote().get(id), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]
		return [model: model]
	}
	
	
	/* save */
	def save(Lote lote) {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be logged to perform this action")
		}

		lote.usuario = mySessionService.usuario
		lote.save(flush:true)

		def model = [
			lote: lote, 
			lotes: Lote.list(),
			categorias: Categoria.list(),
			razas: Raza.list()
		]

		if (lote.hasErrors()) {
			DomainException error = new DomainException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	

	/* search */
	def search() {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}

		def lotes = Lote.list()
		return [lotes:lotes]

	}

	
	/* read */
	def read() {
	}	

	
}
