package evaca

class CategoriaController extends BaseController implements CategoriaExceptionHandler {
	
	def categoriaService

	/* create */
	def create() {
		categoriaService.create()
    }

	
	/* edit */
	def edit() {	
		def model = categoriaService.edit(params.id)
		respond view:'create', model		
    }
	

	/* index */
	def index() {	
		render(view: 'index', model:categoriaService.search())
    }
		

	/* save */
	def save(Categoria categoria) {
	
		categoriaService.save(usuario)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:categoria.id	    
    }


}
