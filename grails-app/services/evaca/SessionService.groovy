package evaca

class UserRegistrationException extends RuntimeException {
	String message
	Map model
}

class SessionService {
	
    static scope = "singleton"
	// static proxy = true


	Date fechaCreacion
	String username
	Usuario usuario
	// Boolean _isLogged = false
	
	// class UserRegistrationException extends RuntimeException {
		// String message
	// }
	
	/* 
	 * login 
	 */
	def login(username, password) {

		def session = RequestContextHolder.currentRequestAttributes().getSession()

		println "---"
		println this.username
		println this.fechaCreacion
		println "---"

		def u = username
		def p = password

		def usuario = Usuario.findByUsername(u)
		if (usuario){
			if (usuario.password == p){
			
				// this.username = u
				// this.fechaCreacion = new Date()
				// this.usuario = usuario
				// this._isLogged = true	
				
				session.username = u
				session.fechaCreacion = new Date()
				session.usuario = usuario
				session.isLogged = true

				println session.isLogged
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
		println session.isLogged
		return session.isLogged
	}
	
	/* 
	 * logout
	 */
	def logout() {

		println "logout!"
		session.isLogged = false
		session.username = null
		session.fechaCreacion = null
		println "logout!!"

	}
}
