package evaca

class UsuarioController {
	
	def sessionService

	/* create */
	def create() {
	
	    def model = [
			usuario: new Usuario(params), 
			usuarios: Usuario.list(),
		]

		[model: model]
    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			usuario: new Usuario().get(id), 
			usuarios: Usuario.list(),
		]

		respond view:'create', [model:model]
    }

	/* login */
	def login() {

		// render "<h1>---" + params + "---</h1>"
		// return
		
		try {
   
			sessionService.login(params.username, params.password)
			def usuario = Usuario.findByUsername(params.username)
			flash.message = "Welcome"
			redirect controller: 'home'
			return
			// render(view: 'home')

		 } catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			render(view: 'login')
		}
    }
	
	/* logout */
	def logout() {

		sessionService.logout()
		def usuario = Usuario.findByUsername(params.username)
		render(view: 'login')
	}	

	/* index */
	def index() {

		def usuarios = Usuario.list()

		render(view: 'index', 
			model: [
				usuarios:usuarios
			]
		)
    }

	/* save */
	def save(Usuario usuario) {

		if (!params.id){
			usuario = new Usuario(params)
		}

		usuario.save(flush:true)

		def model = [
			usuario: usuario, 
			usuarios: Usuario.list(),
		]

		if (usuario.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:usuario.id
	    
    }


}
