package evaca

class SessionService {

	Date fechaCreacion
	String username
	
	class UserRegistrationException extends RuntimeException {
		String message
	}
	
	/* 
	 * login 
	 */
	def login(username, password) {

		println "---"
		println this.username
		println this.fechaCreacion
		println "---"

		def u = username
		def p = password

		def usuario = Usuario.findByUsername(u)
		if (usuario){
			if (usuario.password == p){
				this.username = u
				this.fechaCreacion = new Date()
				println "ok!"
			}
		} else {
            // throw new UserRegistrationException(message:"Passwords don't match")
		}

	}	

	/* 
	 * logout
	 */
	def logout() {

		println "logout!"
		this.username = null
		this.fechaCreacion = null

	}
}
