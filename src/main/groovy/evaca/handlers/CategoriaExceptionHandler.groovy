package evaca
 
trait CategoriaExceptionHandler {
	
	/* CategoriaNotFoundException */
	def exception(CategoriaNotFoundException error) {
		flash.message = error.message
		render "Categoria no encontrada"
		return 
    }

	
	/* CategoriaException */
	def exception(CategoriaException error) {
		flash.message = error.message
		render(view: 'create', model: error.model)
    }


}


