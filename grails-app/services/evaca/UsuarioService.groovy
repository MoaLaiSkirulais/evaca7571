package evaca

class UsuarioException extends RuntimeException {
	String message
	Map model
}

class UsuarioService {
	
	def mySessionService
	
	/* create */
	def create() {
		[usuario: new Usuario()]
	}

	

	/* edit */
	def edit(id) {
		[usuario: new Usuario().get(id)]		
	}

	
	
	/* save */
	def save(Usuario usuario) {

		// try {
			usuario.save(flush:true, failOnError: false)
		// }  catch (org.springframework.orm.hibernate5.HibernateSystemException ure) {        
		// }  catch (all) {        
		//}  catch (DomainException ure) {        
			// def model = [usuario: usuario]

			if (usuario.hasErrors()) {
				UsuarioException error = new UsuarioException(message:"mal")
				error.model = [usuario: usuario]
				throw error;
			}
		// }
		
		
		
	}		
	


	/* joder */
	def joder(Usuario usuario) {
		println "usuarioService.joder"
		def aux = usuario.joder()		
		aux
	}		
	

	
	/* activar */
	def activar(Usuario usuario) {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}

		def aux = usuario.activar()
		usuario.save(flush:true, failOnError: false)
		aux
	}		

	

	/* inactivar */
	def inactivar(Usuario usuario) {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}

		def aux = usuario.inactivar()		
		usuario.save(flush:true, failOnError: false)
		aux
	}		



	/* search */
	def search() {
	
		if (!mySessionService.isAdministrator()) {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}

		def usuarios = Usuario.list()
		return  [usuarios:usuarios]

	}		


	
}
