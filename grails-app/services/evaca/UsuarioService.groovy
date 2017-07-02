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
			println "noo"		
			// def model = [usuario: usuario]

			// if (usuario.hasErrors()) {
				println "!!!!!!!!"
				UsuarioException error = new UsuarioException(message:"mal")
				error.model = [usuario: usuario]
				throw error;
			// }
		// }
		
		
		
	}		
	


	/* joder */
	def joder(Usuario usuario) {
		println "usuarioService.joder"
		def aux = usuario.joder()		
		println aux
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
