package evaca

class OfertaController extends BaseController implements OfertaExceptionHandler{
	
	def ofertaService

	
	/* create */
	def create() {		
		ofertaService.create()
    }


	/* edit */
	def edit() {
		respond view:'create', ofertaService.edit(params.id)		
    }
	

	/* index */
	def index() {

		def ofertas = Oferta.list()
		render(view: 'index', model: [ofertas:ofertas])
    }


	/* save */
	def save(Oferta oferta) {

		ofertaService.save(oferta)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:oferta.id
    }
	
	
	/* changeState */
	def changeState() {		

		def auxState = params._action_changeState as OfertaState
		ofertaService.changeState(params.id, auxState)
		flash.message = "Cambio el estado con exito"
		flash.type = "ok"
		redirect action:"edit", id:params.id
	
    }


}
