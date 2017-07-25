package evaca

class AuthenticatedUsuarioInterceptor {
	
	def mySessionService	
	
	/* AuthenticatedUsuarioInterceptor */
	public AuthenticatedUsuarioInterceptor() {
        match controller: ~/(aviso|lote|oferta|resena)/, 
			action: ~/(index|edit|create|save)/
    }
   

	/* before */
    boolean before() { 
		println ">> AuthenticatedUsuarioInterceptor"
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
	
	
	/* exception */
	def handleUsuarioNotLoggedException (UsuarioNotLoggedException e) {			
		flash.message = e.message        
		redirect controller: 'usuario', action:"newlogin"
	}



}
