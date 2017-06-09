package evaca

class CategoriaException extends RuntimeException {
	String message
	Map model
}

class CategoriaService {
	
	def sessionService
	
	/* create */
	def create() {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}
		
		def model = [
			categoria: new Categoria(), 
			categorias: Categoria.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Categoria categoria) {
	
		if (!sessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}

		categoria.usuario = sessionService.usuario //tal vez no sea necesario ya que viene del create 
		categoria.save(flush:true)

		def model = [
			categoria: categoria
		]

		if (categoria.hasErrors()) {
			CategoriaException error = new CategoriaException(message:"Error actualizando el registro")
			error.model = model
			throw error;
		}
		
	}		
	
	
	/* read */
	def read() {
	}	

	
}
