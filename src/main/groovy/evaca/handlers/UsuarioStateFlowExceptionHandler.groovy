package evaca
 
trait UsuarioStateFlowExceptionHandler {
	
	def exception(UsuarioStateFlowException error) {
		flash.message = error.message
		redirect action:"edit", id:params.id
    }		
	

}


