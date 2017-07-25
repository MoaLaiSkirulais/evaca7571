package evaca

import grails.transaction.*

class UsuarioService {
	
	def mySessionService
	
	/* create */
	def create() {
		[
			usuario: new Usuario(), 
			profiles: UsuarioProfile.values()
		]
	}
	

	/* edit */
	def edit(id) {
		def usuario = new Usuario().get(id)
		if (!usuario){
			throw new UsuarioNotFoundException()
		}
		[usuario: usuario]
	}

	
	/* save */
	def save(Usuario usuario) {

		usuario.save(flush:true, failOnError: false)
		if (usuario.hasErrors()) {
			UsuarioException error = new UsuarioException(message:"mal!")
			error.model = [usuario: usuario]
			throw error;
		}
		return usuario
	}


	/* changeState */
	def changeState(id, UsuarioState newState) {

		def usuario = new Usuario().get(id)
		if (!usuario){
			throw new DomainException(message:"Usuario not found")
		}
		usuario.changeState(newState, mySessionService.usuario)
		usuario.save(flush:true, failOnError: true)

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
