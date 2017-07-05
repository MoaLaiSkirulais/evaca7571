package evaca
import grails.transaction.*

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
		def usuario = new Usuario().get(id)
		[usuario: usuario]
	}

	
	
	/* save */
	def save(Usuario usuario) {
		
		usuario.save(flush:true, failOnError: false)
		if (usuario.hasErrors()) {
			UsuarioException error = new UsuarioException(message:"mal")
			error.model = [usuario: usuario]
			throw error;
		}
	}		
	


	/* joder */
	def joder(Usuario usuario) {
		def aux = usuario.joder()		
		aux
	}		
	

	
	/* activar */
	@Transactional
	def activar(Usuario usuario) {
		def aux = usuario.activar(mySessionService.usuario)
		usuario.save(flush:true, failOnError: false)
		// if (usuario.hasErrors()) {
			// UsuarioException error = new UsuarioException(message:"mal")
			// error.model = [usuario: usuario]
			// throw error;
		// }
		println "activar ------->"
		println usuario.dump()
		usuario
	}		

	

	/* inactivar */
	def inactivar(Usuario usuario) {	
		def aux = usuario.inactivar(mySessionService.usuario)
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
