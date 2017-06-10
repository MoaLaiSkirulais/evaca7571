package evaca

class OfertaController {
	
	def ofertaService

	/* create */
	def create() {
		
		try {
			
			ofertaService.create()
		
		} catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin	"
		}

    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			oferta: new Oferta().get(id), 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def ofertas = Oferta.list()
		render(view: 'index', model: [ofertas:ofertas])
    }

	/* save */
	def save(Oferta oferta) {		
		// oferta.aviso = null
		ofertaService.save(oferta)
		redirect action:"edit", id:oferta.id
    }

	/* exception */
	def exception(UserRegistrationException error) {
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	/* exception */
	def exception(OfertaException error) {
		flash.message = "error"
		respond view:'create', [model:error.model]
    }


}
