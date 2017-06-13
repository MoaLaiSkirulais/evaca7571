package evaca

class UserRegistrationException extends RuntimeException {
	String message
	Map model
}

class SessionService {
	
    static scope = "session"

	Date fechaCreacion
	String username
	Usuario usuario
	Boolean _isLogged = false
	
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
				this.usuario = usuario
				this._isLogged = true

				println this._isLogged
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
		println this._isLogged
		return this._isLogged
	}
	
	/* 
	 * logout
	 */
	def logout() {

		println "logout!"
		this._isLogged = false
		this.username = null
		this.fechaCreacion = null
		println "logout!!"

	}
}
