package evaca

class UsuarioController extends BaseController implements UsuarioExceptionHandler{ 
	
	def mySessionService
	def usuarioService


	/* create */
	def create() {
		usuarioService.create()
    }
	

	/* edit */
	def edit() {
		def model = usuarioService.edit(params.id)
		respond view:'create', model		
    }
	

	/* login */
	def login() {
		mySessionService.login(params.username, params.password)
		def usuario = Usuario.findByUsername(params.username)
		flash.message = "Welcome"
		redirect controller: 'home'	 
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


	/* changeState */
	def changeState() {		

		def auxState = params._action_changeState as UsuarioState
		usuarioService.changeState(params.id, auxState)
		flash.message = "Cambio el estado con exito"
		flash.type = "ok"
		redirect action:"edit", id:params.id

    }


	/* save */
	def save(Usuario usuario) {

		usuarioService.save(usuario)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:usuario.id

    }

	
}
