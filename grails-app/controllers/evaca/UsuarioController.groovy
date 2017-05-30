package evaca

class UsuarioController {

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
