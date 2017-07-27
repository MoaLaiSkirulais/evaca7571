package evaca
 
trait RazaExceptionHandler {
	
	/* RazaNotFoundExceptionHandler */
	def exception(RazaNotFoundException error) {
		flash.message = error.message
		render "Raza no encontrada"
		return 
    }

	
	/* RazaExceptionHandler */
	def exception(RazaException error) {
		flash.message = error.message
		render(view: 'create', model: error.model)
    }
	

}
