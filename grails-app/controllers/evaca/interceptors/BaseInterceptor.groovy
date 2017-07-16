package evaca


class BaseInterceptor {
	
	def mySessionService	
	
	public BaseInterceptor() {
        // match action: 'index'
        // match controller: ~/(raza)/ 
        match controller: ~/(raza|categoria)/, action: ~/(index|edit|create|save)/
    }
 

	/* before */
    boolean before() { 
		println "base intercept!!!!"
		if (!mySessionService.isAdministrator()) {
			// throw new UserRegistrationException(message:"You must be logged to perform this action")
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
