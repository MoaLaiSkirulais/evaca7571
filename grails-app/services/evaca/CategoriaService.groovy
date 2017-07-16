package evaca

class CategoriaException extends RuntimeException {
	String message
	Map model
}

class CategoriaService {
	
	def mySessionService
	
	/* create */
	def create() {
	
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
	
		categoria.usuario = mySessionService.usuario 
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
