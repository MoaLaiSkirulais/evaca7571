package evaca

class UsuarioController extends BaseController implements UsuarioExceptionHandler{ 
	
	def mySessionService
	def usuarioService
	def avisoService
	def loteService


	/* create */
	def create() {
		usuarioService.create()
    }
	

	/* editProfile */
	def editProfile() {
		respond ( 
			view:'editProfile', 
			getViewModel(usuarioService.edit(params.id))
		)		
    } 
	
	
	/* admin */
	def admin() {		
		respond ( 
			view:'admin', 
			getViewModel(usuarioService.edit(params.id))
		)		
    } 
	
 
	/* showProfile */
	def showProfile() {
	
		def usuarioId
		
		if (params.id){
			usuarioId = params.id
		}
		
		if (!params.id){
			usuarioId = mySessionService.usuario.id
		}
	
		respond ( 
			view:'showProfile', 
			getViewModel(usuarioService.edit(usuarioId))
		)		
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
	
	
	/* aprobar (admin) */
	def aprobar() {
		changeState.call(usuarioService.&aprobar)
    }

	
	/* desaprobar (admin) */
	def desaprobar() {
		changeState.call(usuarioService.&desaprobar)
    }


	/* postular (visitante) */
	def postular(Usuario usuario) {
		try {

			usuarioService.postular(usuario)
			flash.message = "La cuenta fue creada. Ahora deberá ser activada para poder utilizarla."
			flash.type = "ok"
			redirect controller:"message", action:"show"

		} catch (UsuarioException error){

			flash.message = error.message
			render(view: 'create', model: [usuario:usuario])
		}
    }

	
	/* changeState */
	def changeState = { 
		
		try {			
			it(params.int('id'));  
		} catch (OfertaException e){
			flash.message = e.message
			redirect action:"edit", id:params.int('id')
			return
		}

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:params.int('id')
		
	}   
	
	
	/* getViewModel */ /* closure? trait? service? */
	def getViewModel(Usuario usuario){
		[
			usuario: usuario, 
			profiles: usuarioService.getProfiles()
		]
	}
	
		
	/* saveAvatar */ 
	def saveAvatar(SaveAvatarCommand cmd) {	
        usuarioService.saveAvatar(cmd)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"showProfile", id:params.int('id')
    }

	
	/* editPassword */ 
	def editPassword() {	        
		respond ( 
			view:'editPassword',
			getViewModel(usuarioService.edit(params.id))
		)
    }

	
	/* savePassword */ 
	def savePassword(SavePasswordCommand command) {	
        usuarioService.savePassword(command)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"showProfile", id:params.int('id')
    }

	
	/* saveProfile */ 
	def saveProfile(SaveProfileCommand command) {	
        usuarioService.saveProfile(command)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"showProfile", id:params.int('id')
    }

	
	/* editAvatar */
	def editAvatar() {
		respond ( 
			view:'editAvatar',
			getViewModel(usuarioService.edit(params.id))
		)
    }


	/* getAvatarImage */
	def getAvatarImage(Usuario usuario) {
        if (usuario == null || usuario.avatarImageBytes == null) {            
            return
        }
        render file: usuario.avatarImageBytes, contentType: usuario.avatarImageContentType
    }


	// /* save */
	// def save(Usuario usuario) {

		// usuarioService.save(usuario)
		// flash.message = "Cambios aplicados con exito"
		// flash.type = "ok"
		// redirect action:"edit", id:usuario.id

    // }
	
	/* index */
	def avisos() {
	
		render(view: 'avisos', 
			model: [
				usuario: getViewModel(usuarioService.edit(1)), 
				avisos: Aviso.list(), 
				lote:[
					consignatarios: Usuario.list().sort{it.nombre}, 
					categorias: Categoria.list().sort{it.nombre}, 
					vendedores: Usuario.list().sort{it.nombre}, 
					razas: Raza.list().sort{it.nombre}
				]
			]
		)

    }
	
	
}
