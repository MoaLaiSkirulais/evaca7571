package evaca

class OfertaController extends BaseController implements OfertaExceptionHandler{
	
	def ofertaService

	
	/* create */
	def create() {
		render(view: 'create', model:ofertaService.create())
    }


	/* edit */
	def edit() {
		respond view:'create', ofertaService.edit(params.id)		
    }


	/* index */
	def index() {
		render(view: 'index', model: [ofertas:ofertaService.search()])
    }


	/* save */
	def save(Oferta oferta) {

		ofertaService.save(oferta)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:oferta.id
    }


	/* setStateAprobacion (ofertante) */
	def setStateAprobacion(Oferta oferta) {

		try {
			ofertaService.setStateAprobacion(oferta);  
		} catch (OfertaException e){
			flash.message = e.message
			render(view: 'create', model:getViewModel(oferta))
			return
		}

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:oferta.id
    }
	
	
	/* setStateCancelado (ofertante) */
	def setStateCancelado() {
		changeState.call(ofertaService.&setStateCancelado)
    }


	/* setStateAprobado (admin) */
	def setStateAprobado() {
		changeState.call(ofertaService.&setStateAprobado)
    }

	
	/* setStateDesaprobado (admin) */
	def setStateDesaprobado() {
		changeState.call(ofertaService.&setStateDesaprobado)
    }


	/* setStateAceptado (vendedor) */
	def setStateAceptado() {
		changeState.call(ofertaService.&setStateAceptado)
    }


	/* setStateRechazado (vendedor) */
	def setStateRechazado() {
		changeState.call(ofertaService.&setStateRechazado)
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
	def getViewModel(Oferta oferta){
		[
			oferta: oferta, 
			plazos: ofertaService.getPlazos(), 
			avisos: ofertaService.getAvisos()
		]
	}


}
