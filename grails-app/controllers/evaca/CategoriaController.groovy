package evaca

class CategoriaController extends BaseController implements CategoriaExceptionHandler {
	
	def categoriaService
	def usuarioService

	/* create */
	def create() {
		categoriaService.create()
    }

	
	/* edit */
	def edit() {	
		def model = categoriaService.edit(params.id)
		respond view:'create', model		
    }
	

	/* search */
	def search() {	
		render(
			view: 'search', 
			model: [
				usuario: usuarioService.edit(1), 
				categorias: categoriaService.search()
			]
		)
    }
		

	/* save */
	def save(Categoria categoria) {
	
		categoriaService.save(categoria)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:categoria.id	    
    }


}
