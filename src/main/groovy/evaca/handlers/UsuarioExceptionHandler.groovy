package evaca
 
trait UsuarioExceptionHandler {
	
	/* UsuarioStateFlowException */
	def exception(UsuarioStateFlowException error) {
		flash.message = error.message
		redirect action:"edit", id:params.id
    }

	
	/* UsuarioException */
	def exception(UsuarioException error) {
		flash.message = error.message
		render(view: 'create', model: error.model)
    }


	/* UsuarioException */
	def exception(LoginException error) {
		flash.message = error.message
		render(view: 'login')
    }	
	

	

}


