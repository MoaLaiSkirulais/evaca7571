package evaca

/* OfertaService */
class OfertaService {
	
	def mySessionService
	
	/* create */
	def create() {
		
		[
			oferta: new Oferta([usuario:mySessionService.usuario]), 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]
	}

	
	/* edit */
	def edit(id) {
	
		def oferta = new Oferta().get(id)
		if (!oferta){
			throw new OfertaNotFoundException()
		}

		[
			oferta: oferta, 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]

	}
	
	
	/* save */
	def save(Oferta oferta) {
		
		oferta.usuario = mySessionService.usuario
		oferta.save(flush:true, failOnError: false)

		if (oferta.hasErrors()) {
		
			OfertaException error = new OfertaException(message:"Errors!")
			error.model = [
					oferta: oferta, 
					avisos: Aviso.list(), 
					plazos: Plazo.list()
				]
			throw error;
		}		
	}	

	
	/* changeState */
	def changeState(id, OfertaState newTbState) {

		def oferta = new Oferta().get(id)		
		if (!oferta){
			throw new OfertaNotFoundException()
		}

		oferta.changeState(newTbState, mySessionService.usuario)
		oferta.save(flush:true, failOnError: true)

    }
	
}
