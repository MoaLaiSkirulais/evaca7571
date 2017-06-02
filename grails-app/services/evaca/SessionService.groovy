package evaca

class UserRegistrationException extends RuntimeException {
	String message
}

class SessionService {

	Date fechaCreacion
	String username
	Boolean isLogged = false
	
	// class UserRegistrationException extends RuntimeException {
		// String message
	// }
	
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
				this.isLogged = true

				println this.isLogged
				println "ok!"
			} else {
				throw new UserRegistrationException(message:"Passwords don't match")
			}
		} else {
            throw new UserRegistrationException(message:"Invalid user")
		}

	}	

	/* 
	 * isLogged
	 */
	def isLogged() {
		println this.isLogged
		return this.isLogged
	}
	
	/* 
	 * logout
	 */
	def logout() {

		println "logout!"
		this.isLogged = false
		this.username = null
		this.fechaCreacion = null
		println "logout!!"

	}
}
