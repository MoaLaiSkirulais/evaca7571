package evaca

class UsuarioController extends BaseController{
	
	def mySessionService
	def usuarioService

	

	/* create */
	def create() {
		usuarioService.create()
    }

	

	/* edit */
	def edit() {		
		respond view:'create', usuarioService.edit(params.id)
    }

	

	/* login */
	def login() {
		
		try {
   
			mySessionService.login(params.username, params.password)
			def usuario = Usuario.findByUsername(params.username)
			flash.message = "Welcome"
			redirect controller: 'home'
			return

		 } catch (MyUserRegistrationException ure) {        

			flash.message = ure.message        
			render(view: 'login')
		}
    }

	

	/* login */
	def newlogin() {
		render(view: 'login')		
    }

	

	/* logout */
	def logout() {
		mySessionService.logout()
		def usuario = Usuario.findByUsername(params.username)
		render(view: 'login')
	}	

	

	/* index */
	def index() {
		render(view: 'index', model:usuarioService.search())		
    }



	/* joder */
	def joder(Usuario usuario) {
	
		try {
			usuarioService.joder(usuario)			
		} catch (DomainException ure) {			
			flash.message = ure.message
			render(view: 'create', model: [usuario: usuario])
		}
    }

	

	/* save */
	def save(Usuario usuario) {
		// usuario.tbState = 'Activo'
		try {
			usuarioService.save(usuario)
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:usuario.id
		}  catch (grails.validation.ValidationException error) {        
			flash.message = "Mal"
			render(view: 'create', model: [usuario: error.model])
			println "noo..........."
		}  catch (UsuarioException error) {        
			flash.message = "Mal"
			render(view: 'create', model: error.model)
			println "noo.........................-------------------"
		}
    }
	

}
