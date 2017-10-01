package evaca

class UserLoggedInterceptor {
	
	def mySessionService	
	
	/* UserLoggedInterceptor */
	public UserLoggedInterceptor() {

		match (
			controller: ~/(aviso)/, 
			action: ~/(|search|postular_oferta)/
		)

		match (
			controller: ~/(oferta|lote|resena)/, 
			action: ~/(|search|edit|create|show)/
		)

		match (
			controller: ~/(usuario)/, 
			action: ~/(|index|edit|show_profile|edit_avatar|edit_password|edit_profile)/
		)
		
		match (
			controller: ~/(oferta)/, 
			action: ~/(aceptar|rechazar|postular|cancelar)/
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
