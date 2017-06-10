package evaca

class PlazoController {
	
	def plazoService

	/* create */
	def create() {
		
		try {
		
			plazoService.create()		

		} catch (UserRegistrationException ure) {
		
			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin	"

		}

    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			plazo: new Plazo().get(id)
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def plazos = Plazo.list()

		render(view: 'index', 
			model: [
				plazos:plazos
			]
		)
    }

	/* save */
	def save(Plazo plazo) {
		plazoService.save(plazo)
		redirect action:"edit", id:plazo.id
	}	
	
	/* exception */
	def exception(UserRegistrationException error) {
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	/* exception */
	def exception(PlazoException error) {
		flash.message = "error"
		respond view:'create', [model:error.model]
    }


}
