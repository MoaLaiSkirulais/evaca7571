package evaca

class PreguntaController {
	
	def preguntaService

	/* create */
	def create() {
		
		try {			
			preguntaService.create()		
		} catch (UserRegistrationException ure) {        
			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin"
		}

    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			pregunta: new Pregunta().get(id), 
			preguntas: Pregunta.list()
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def preguntas = Pregunta.list()

		render(view: 'index', 
			model: [
				preguntas:preguntas
			]
		)
    }

	/* save */
	def save(Pregunta pregunta) {

		try {
		
			preguntaService.save(pregunta)
			redirect action:"edit", id:pregunta.id			

		} catch (UserRegistrationException error) {        

			flash.message = error.message        
			redirect controller: 'usuario', action:"newlogin	"

		} catch (PreguntaException error) {        

			flash.message = error.message 
			respond view:'create', [model:error.model]
			return
		}
	    
    }


}
