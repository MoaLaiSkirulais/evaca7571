package evaca

class CategoriaService {
	
	def mySessionService
	
	/* create */
	def create() {

		[
			categoria: new Categoria(usuario:mySessionService.usuario), 
			categorias: Categoria.list()
		]
	}
	
	
	/* edit */
	def edit(id) {
		def categoria = new Categoria().get(id)
		if (!categoria){
			throw new CategoriaNotFoundException()
		}
		[categoria: categoria]
	}
	
	
	/* save */
	def save(Categoria categoria) {
	
		categoria.save(flush:true, failOnError: false)
		if (categoria.hasErrors()) {
			CategoriaException error = new CategoriaException()
			error.model = [categoria: categoria]
			throw error;
		}
		return categoria
		
	}		

	
	/* search */
	def search() {
	
		def categorias = Categoria.list()
		return  [categorias:categorias]

	}		
	
	
}
