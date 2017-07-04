package evaca
import org.grails.web.util.WebUtils

/* 
 * MyUserRegistrationException
 */
class MyUserRegistrationException extends RuntimeException {
	String message
	Map model
}

/* 
 * MySessionService 
 */
class MySessionService {
	
	Date fechaCreacion = new Date()
	String username
	Usuario usuario


	
	/* login */
	def login(username, password) {
		
		def u = username
		def p = password
		
		def session = WebUtils.retrieveGrailsWebRequest().session

		def usuario = Usuario.findByUsername(u)
		if (usuario){
			if (usuario.password == p){

				session.username = u
				session.fechaCreacion = new Date()
				session.usuario = usuario
				session.isLogged = true
				
			} else {
				throw new MyUserRegistrationException(message:"Passwords don't match")
			}
		} else {
            throw new MyUserRegistrationException(message:"Invalid user")
		}

	}	

	
	
	/* isLogged */
	def isLogged() {
		def session = WebUtils.retrieveGrailsWebRequest().session
		// return true
		return session.isLogged
	}
	


	/* isAdministrator */
	def isAdministrator() {
		// return true
		if (isLogged()){
			def session = WebUtils.retrieveGrailsWebRequest().session
			[session.usuario.tbTipo == 'Administrador']
		}
	}

	

	/* getUsername */
	def getUsername() {			
		def session = WebUtils.retrieveGrailsWebRequest().session
		return session.username
	}
	

	
	/* getUsuario */
	def getUsuario() {			
		def session = WebUtils.retrieveGrailsWebRequest().session
		return session.usuario
	}
	

	
	/* logout */
	def logout() {
		def session = WebUtils.retrieveGrailsWebRequest().session
		session.isLogged = false
		session.username = null
		session.fechaCreacion = null
	}
}
