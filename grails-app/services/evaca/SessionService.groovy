package evaca

class SessionService {

	Date fechaCreacion
	String username
	
	/* 
	 * login 
	 */
	def login() {

		println "---"
		println this.username
		println this.fechaCreacion
		println "---"
		
		def u = "lcastro"
		def p = "Castro"
		
		def usuario = Usuario.findByUsername(u)
		if (usuario){
			if (usuario.password == p){
				this.username = u
				this.fechaCreacion = new Date()
				println "ok!"
			}
		}
	}	
	
	/* 
	 * logout
	 */
	def logout() {

		println "logout"		
		this.username = null
		this.fechaCreacion = null

	}
}
