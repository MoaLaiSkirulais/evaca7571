package evaca

import grails.transaction.*

class UsuarioService {
	
	def mySessionService
	
	/* getConsignatarios */
	def getProfiles() {

		// def consignatarios = Usuario.createCriteria().list () {
			// eq("profile", UsuarioProfile.CONSIGNATARIO)
		// }
		println "---" + UsuarioProfile.values()
		return UsuarioProfile.values()
	}

	
	/* create */
	def create() {
		return new Usuario()
	}
	

	/* edit */
	def edit(id) {
		def usuario = new Usuario().get(id)
		if (!usuario){
			throw new UsuarioNotFoundException()
		}
		return usuario
	}


	/* aprobar */
	def aprobar(Long id) {	
	
		def usuario = new Usuario().get(id)
		if (!usuario){
			throw new UsuarioNotFoundException();
		}

		usuario.changeState(UsuarioState.APROBADO, mySessionService.usuario)
		usuario.save(flush:true, failOnError: false)
	}	

	
	/* desaprobar */
	def desaprobar(Long id) {	
	
		def usuario = new Usuario().get(id)
		if (!usuario){
			throw new UsuarioNotFoundException();
		}

		usuario.changeState(UsuarioState.DESAPROBADO, mySessionService.usuario)
		usuario.save(flush:true, failOnError: false)
	}	

	
	/* postular */
	def postular(Usuario usuario) {	

		usuario.changeState(UsuarioState.POSTULADO, mySessionService.usuario)
		usuario.save(flush:true, failOnError: false)

		if (usuario.hasErrors()) {
			throw new UsuarioException();
		}
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
