package evaca

class AdminLoggedInterceptor {
	
	def mySessionService	

	
	/* AdminLoggedInterceptor */
	public AdminLoggedInterceptor() {
        match(
			controller: ~/(categoria|plazo|raza|pregunta)/, 
			action: ~/(|search|edit|create|save)/
		)
		
		match(controller: ~/(aviso|oferta)/, 
			action: ~/(desaprobar|aprobar)/
		)		
		
		match(controller: ~/(usuario)/, 
			action: ~/(desaprobar|aprobar|admin)/
		)				
		
		match(controller: ~/(admin)/
		)				
    }
   

	/* before */
    boolean before() { 

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
