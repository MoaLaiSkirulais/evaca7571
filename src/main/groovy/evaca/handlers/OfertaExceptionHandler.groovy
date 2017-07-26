package evaca
 
trait OfertaExceptionHandler {
	
	/* OfertaStateFlowException */
	def exception(OfertaStateFlowException error) {
		flash.message = error.message
		redirect action:"edit", id:params.id
    }		

	
	/* OfertaException */
	def exception(OfertaException error) {
		flash.message = error.message
		render(view: 'create', model: error.model)
    }
	

}


