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
			avisos: Aviso.list()
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def ofertas = Oferta.list()

		render(view: 'index', 
			model: [
				ofertas:ofertas
			]
		)
    }

	/* save */
	def save(Oferta oferta) {

		try {
		
			ofertaService.save(oferta)
			redirect action:"edit", id:oferta.id			

		} catch (UserRegistrationException error) {        

			flash.message = error.message        
			redirect controller: 'usuario', action:"newlogin"

		} catch (OfertaException error) {        

			flash.message = error.message 
			respond view:'create', [model:error.model]
			return
		}

    }


}
