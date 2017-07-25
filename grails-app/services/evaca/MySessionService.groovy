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
			println "-->" + p
			println "-->" + usuario.password
			println "-->" + usuario
			
			if (usuario.state != UsuarioState.ACTIVO){
				throw new LoginException(message:"La cuenta no esta aun activa")
			}
			
			
			if (usuario.password == p){

				session.username = u
				session.fechaCreacion = new Date()
				session.usuario = usuario
				session.isLogged = true
				
			} else {
				throw new LoginException(message:"Passwords don't match")
			}
		} else {
            throw new LoginException(message:"Invalid user")
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
			[session.usuario.profile == UsuarioProfile.ADMINISTRADOR]
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
		session.usuario = null
	}
}
