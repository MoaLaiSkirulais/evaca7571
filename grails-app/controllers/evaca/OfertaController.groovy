package evaca

class OfertaController extends BaseController implements OfertaExceptionHandler{
	
	def ofertaService
	def mySessionService


	/* admin */
	def admin() {
		render (view: 'admin', model: getViewModel(ofertaService.edit(params.id)))
    }


	/* create */
	def create() {
		render (view: 'create', model: getViewModel(ofertaService.create()))
    }


	/* edit */
	def edit() {
		respond (view:'create', getViewModel(ofertaService.edit(params.id)))
    }


	/* search */ 
	def search() {
	
		def ofertas = Oferta.createCriteria().list(){
		
			if (mySessionService.usuario.id) {
				aviso{propietario{eq("id", mySessionService.usuario.id)}}
			}
		}

		render(view: 'search', model: [ofertas : ofertas])
    }


	/* postular (ofertante) */
	def postular(Oferta oferta) {

		try {
		
			ofertaService.postular(oferta);  
			
		} catch (OfertaException e){

			flash.message = e.message
			render (view: 'create', model:getViewModel(oferta))
			return
		}

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:oferta.id
    }
	
	
	/* cancelar (ofertante) */
	def cancelar() {
		changeState.call(ofertaService.&cancelar)
    }


	/* aprobar (admin) */
	def aprobar() {
		changeState.call(ofertaService.&aprobar)
    }

	
	/* desaprobar (admin) */
	def desaprobar() {
		changeState.call(ofertaService.&desaprobar)
    }


	/* aceptar (vendedor) */
	def aceptar() {
		changeState.call(ofertaService.&aceptar)
    }


	/* rechazar (vendedor) */
	def rechazar() {
		changeState.call(ofertaService.&rechazar)
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
