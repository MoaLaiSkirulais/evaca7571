package evaca

class CategoriaException extends RuntimeException {
	String message
	Map model
}

class CategoriaService {
	
	def mySessionService
	
	/* create */
	def create() {
	
		if (!mySessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}
		
		def categoria = new Categoria()
		categoria.usuario = mySessionService.usuario
		
		def model = [
			categoria: categoria, 
			categorias: Categoria.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Categoria categoria) {
	
		if (!mySessionService.isLogged()) {
			throw new UserRegistrationException(message:"You must be logged in to perform this action")
		}

		categoria.usuario = mySessionService.usuario //tal vez no sea necesario ya que viene del create 
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
