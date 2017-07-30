package evaca
 
trait AvisoExceptionHandler {
	
	/* AvisoExceptionHandler */
	def exception(AvisoException error) {
	
		render aviso
		return
		flash.message = error.message
		render(view: 'create', model: error.model)
    }
	

}


