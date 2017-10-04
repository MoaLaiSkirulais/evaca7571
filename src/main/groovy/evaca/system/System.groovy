package evaca

import org.springframework.core.io.Resource

class System {
	
	def mySessionService

	/* errorAndRedirect */ 
	def errorAndRedirect(String message, String action) {	
	
		flash.message = message
		flash.type = "error"
		redirect (action: action)

    }
	
	
	/* successAndRedirect */ 
	def successAndRedirect(String message, String action) {	
	
		flash.message = message
		flash.type = "ok"
		redirect (action: action)

    }
	
}