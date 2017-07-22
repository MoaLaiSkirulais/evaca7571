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
		def model = usuarioService.edit(params.id)
		respond view:'create', model		
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


	/* changeState */
	def changeState() {		
	
		// render params
		// return

		// def aviso = new Aviso().get(params.id)
		
		def auxState
		if (params.newTbState == "UsuarioState.APROBACION"){
			auxState = UsuarioState.APROBACION
		}
		
		if (params.newTbState == "UsuarioState.ACTIVO"){
			auxState = UsuarioState.ACTIVO
		}
		
		if (params.newTbState == "UsuarioState.INACTIVO"){
			auxState = UsuarioState.INACTIVO
		}

		try {

			usuarioService.changeState(params.id, auxState)
			flash.message = "bien!"
			flash.type = "ok"
			redirect action:"edit", id:params.id
			
		}  catch (DomainException error) {  
		
			println "redirect"
			flash.message = error.message
			redirect action:"edit", id:params.id
		}
    }


	/* save */
	def save(Usuario usuario) {
	
		
		// render params.id
		// render params._action_save
		// return


		try {
			usuarioService.save(usuario)
			render usuario.id
			return
			usuarioService.changeState(usuario.id, params._action_save as UsuarioState)
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:usuario.id
			
			
			
		}  catch (grails.validation.ValidationException error) {        
			flash.message = "Mal"
			render(view: 'create', model: [usuario: error.model])
			println "grails.validation.ValidationException error"
		}  catch (UsuarioException error) {        
			flash.message = "Mal"
			render(view: 'create', model: error.model)
			println "UsuarioException"
		}
		
		    // } catch(Exception e){
        // e.printStackTrace()

    }
	

}
