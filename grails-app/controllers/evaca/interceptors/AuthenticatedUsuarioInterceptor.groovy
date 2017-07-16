package evaca


class AuthenticatedUsuarioInterceptor {
	
	def mySessionService	
	
	public AuthenticatedUsuarioInterceptor() {
        match controller: ~/(lote|oferta|resena)/, 
			action: ~/(index|edit|create|save)/
    }
   

	/* before */
    boolean before() { 
		println ">> AuthenticatedUsuarioInterceptor"
		if (!mySessionService.isLogged()) {
			// throw new UserRegistrationException(message:"You must be logged to perform this action")
			flash.message = "You must be logged to perform this action"
            redirect controller: 'usuario', action:"newlogin"
            return false

		}
		true 
	}


	/* after */
	boolean after() { 
		true 
	}

	
	void afterView() {
    }


}
