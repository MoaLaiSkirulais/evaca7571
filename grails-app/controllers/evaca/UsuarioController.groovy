package evaca

// import org.codehaus.groovy.grails.core.io.ResourceLocator
import org.springframework.core.io.Resource

class UsuarioController extends BaseController implements UsuarioExceptionHandler{ 
	
	def mySessionService
	def usuarioService
	def avisoService
	def loteService
	def grailsResourceLocator

	/* create */
	def create() {
		respond ( 
			view:'create', 
			getViewModel(usuarioService.create())
		)		
    }
	

	/* edit_profile */
	def edit_profile() {
		respond ( 
			view:'edit_profile', 
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
	
 
	/* show_profile */
	def show_profile() {
	
		def usuarioId
		
		if (params.id){
			usuarioId = params.id
		}
		
		if (!params.id){
			usuarioId = mySessionService.usuario.id
		}
	
		respond ( 
			view:'show_profile', 
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
	def postular(PostularCommand cmd) {
		try {

			usuarioService.postular(cmd)
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
	def save_avatar(SaveAvatarCommand cmd) {	
        usuarioService.saveAvatar(cmd)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"show_profile", id:params.int('id')
    }

	
	/* edit_password */ 
	def edit_password() {	        
		respond ( 
			view:'edit_password',
			getViewModel(usuarioService.edit(params.id))
		)
    }

	
	/* savePassword */ 
	def save_password(SavePasswordCommand command) {	
        usuarioService.savePassword(command)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"show_profile", id:params.int('id')
    }

	
	/* saveProfile */ 
	def save_profile(SaveProfileCommand command) {	
        usuarioService.saveProfile(command)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"show_profile", id:params.int('id')
    }

	
	/* edit_avatar */
	def edit_avatar() {
		respond ( 
			view:'edit_avatar',
			getViewModel(usuarioService.edit(params.id))
		)
    }


	/* get_avatar_image */
	def get_avatar_image(Usuario usuario) { /* levanta el user de db! */
	
        if (usuario == null) {            
			println "no hay user"
			render "no-image"
            return
        }
		
		// render (file: usuario.avatarImageBytes, contentType: usuario.avatarImageContentType)
        // render (file: generic, contentType: usuario.avatarImageContentType)
		// final Resource image = grailsResourceLocator.findResourceForURI('/7.jpg')
		final Resource image = grailsResourceLocator.findResourceForURI('/sham/img/users/anon.png')
        // render (file: image.inputStream, fileName: '7.jpg', contentType: usuario.avatarImageContentType)
        render (file: image.inputStream, contentType: usuario.avatarImageContentType)
		return
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
