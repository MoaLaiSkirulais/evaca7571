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
	def exception(DomainException error) {
		flash.message = "error"
		respond view:'create', [model:error.model]
    }	


	/* exception */
	def exception(UsuarioNotFoundException e) {			
		flash.message = e.message        
		render e.message
		return
	}

	
	/* exception */
	def handleUsuarioNotLoggedException (UsuarioNotLoggedException e) {			
		flash.message = e.message        
		redirect controller: 'usuario', action:"newlogin"
	}
	

}
