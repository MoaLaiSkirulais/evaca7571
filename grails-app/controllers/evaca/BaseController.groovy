package evaca

class BaseController {
	
	
	/* exception */
	def exception(UserRegistrationException error) {
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	
	
	/* exception */
	def exception(PlazoException error) {
		flash.message = "error"
		respond view:'create', [model:error.model]
    }
	
	

	/* exception */
	def exception(UsuarioException error) {
		flash.message = "error"
		respond view:'create', [model:error.model]
    }

}
