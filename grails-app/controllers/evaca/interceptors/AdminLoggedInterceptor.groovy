package evaca

class AdminLoggedInterceptor {
	
	def mySessionService	

	
	/* AdminLoggedInterceptor */
	public AdminLoggedInterceptor() {
        match(
			controller: ~/(categoria|plazo|raza)/, 
			action: ~/(|index|edit|create|save)/
		)
		
		match(controller: ~/(aviso)/, 
			action: ~/(rechazar|aprobar)/
		)		
    }
   

	/* before */
    boolean before() { 
		println ">> AdminLoggedInterceptor"
		if (!mySessionService.isAdministrator()) {
			flash.message = "You must be admin to perform this action"
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
