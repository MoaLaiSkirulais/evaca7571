package evaca

class CategoriaController {


	/* edit */
	def edit(Categoria categoria) {
        respond categoria
    }
    
	/* index */
	def index() {
	
		def categorias = Categoria.list()

		render(view: 'index', 
			model: [
				categorias:categorias
			]
		)
    }
}
