package evaca
 
trait PlazoExceptionHandler {
	
	/* PlazoNotFoundExceptionHandler */
	def exception(PlazoNotFoundException error) {
		flash.message = error.message
		render "Plazo no encontrada"
		return 
    }

	
	/* PlazoExceptionHandler */
	def exception(PlazoException error) {
		flash.message = error.message
		render(view: 'create', model: error.model)
    }


}
