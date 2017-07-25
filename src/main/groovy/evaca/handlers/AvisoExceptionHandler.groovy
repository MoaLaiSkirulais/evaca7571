package evaca
 
trait AvisoExceptionHandler {
	
	/* AvisoExceptionHandler */
	def exception(AvisoException error) {
		flash.message = error.message
		render(view: 'create', model: error.model)
    }
	

}


