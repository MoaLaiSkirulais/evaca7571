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

	

	/* save */
	def save(Usuario usuario) {
		usuarioService.save(usuario)
		redirect action:"edit", id:usuario.id
    }


}
