package evaca

class UserLoggedInterceptor {
	
	def mySessionService	
	
	/* UserLoggedInterceptor */
	public UserLoggedInterceptor() {

		match (
			controller: ~/(aviso|oferta|lote)/, 
			action: ~/(|index|edit|create)/
		)
		
		match (
			controller: ~/(usuario)/, 
			action: ~/(|index|edit)/
		)
    }
   

	/* before */
    boolean before() { 
		println ">> UserLoggedInterceptor"
		if (!mySessionService.isLogged()) {
			// throw new UsuarioNotLoggedException()
			flash.message = "You must be logged to perform this action"
            redirect controller: 'usuario', action:"newlogin"
			return /* importante este return */
		}
		true 
	}


	/* after */
	boolean after() { 
		true 
	}

	
	/* afterView */
	void afterView() {
    }


}
