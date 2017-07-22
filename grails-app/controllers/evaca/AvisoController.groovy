package evaca

class AvisoController extends BaseController{
	
	public String casa = "casa"
	def avisoService


	/* create */
	def create() {	
	    avisoService.create()
    }

	
	/* edit */
	def edit() {
		respond view:'create', avisoService.edit(params.id)
    }


	/* index */
	def index() {
	
		render(view: 'index', 
			model: [
				avisos: avisoService.search(), 
				lote:[
					consignatarios: Usuario.list().sort{it.nombre}, 
					categorias: Categoria.list().sort{it.nombre}, 
					vendedores: Usuario.list().sort{it.nombre}, 
					razas: Raza.list().sort{it.nombre}
				]
			]
		)

    }

	/* save */
	def save(Aviso aviso) {

		// try {

			avisoService.save(aviso)
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:aviso.id

		// }  catch (UsuarioException error) {
		
			// flash.message = "Mal"
			// render(view: 'create', model: error.model)
			// println "UsuarioException"
		// }

    }
	
	/* show */
	def show() {

		def id=params.id
		render(view: 'show', 
			model: [
				aviso: new Aviso().get(id),
				plazos: Plazo.list()
			]
		)
    }
	
	/* changeState */
	def changeState() {		
	
		render params
		return

		// def aviso = new Aviso().get(params.id)
		
		def auxState
		if (params.newTbState == "AvisoState.PUBLICADO"){
			auxState = AvisoState.PUBLICADO
		}
		
		if (params.newTbState == "AvisoState.RECHAZADO"){
			auxState = AvisoState.RECHAZADO
		}
		
		if (params.newTbState == "AvisoState.CANCELADO"){
			auxState = AvisoState.CANCELADO
		}

		try {
			avisoService.changeState(params.id, auxState)
			flash.message = "bien!"
			flash.type = "ok"
			redirect action:"edit", id:params.id
		}  catch (DomainException error) {  
			flash.message = error.message
			redirect action:"edit", id:params.id
		}
    }
	
	/* ofertar */
	def ofertar(Oferta oferta) {		
		ofertaService.save(oferta)
		redirect action:"show", id:oferta.aviso.id 
    }
	
	/* exception */
	def exception(UserRegistrationException error) {
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	/* exception */
	def exception(OfertaException error) {
		flash.message = "error"
		render error.model.oferta.aviso
		def model = [
				aviso: error.model.oferta.aviso,
				plazos: Plazo.list()
			]
		respond view:'show', [model:model]
    }
	
	/* exception */
	def exception(DomainException error) {
		render "eeeee"
		render(view: 'create', [model: model])
    }	


}
