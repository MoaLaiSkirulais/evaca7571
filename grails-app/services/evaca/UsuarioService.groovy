package evaca

class UsuarioException extends RuntimeException {
	String message
	Map model
}

class UsuarioService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		def model = [
			usuario: new Usuario(), 
			usuarios: Usuario.list(),
		]

		[model: model]
		
	}

	
	
	/* edit */
	def edit(id) {
		
	    def model = [
			usuario: new Usuario().get(id), 
			usuarios: Usuario.list(),
		]
		return [model: model]
		
	}

	
	
	/* save */
	def save(Usuario usuario) {

		usuario.save(flush:true)
		def model = [usuario: usuario]

		if (usuario.hasErrors()) {
			UsuarioException error = new UsuarioException(message:"Errors!")
			error.model = model
			throw error;
		}
		
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
