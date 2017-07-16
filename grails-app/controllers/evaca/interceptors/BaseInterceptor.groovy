package evaca


class BaseInterceptor {
	
	def mySessionService	
	
	public BaseInterceptor() {
        match controller: ~/(raza|categoria|plazo)/, 
			action: ~/(index|edit|create|save)/
    }
  

	/* before */
    boolean before() { 
		println "base intercept!!!!"
		if (!mySessionService.isAdministrator()) {
			// throw new UserRegistrationException(message:"You must be logged to perform this action")
			flash.message = "You must be admin to perform this action"
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
