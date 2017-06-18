package evaca

class ResenaController {
	
	def resenaService

	/* create */
	def create() {
		
		try {
			
			resenaService.create()
		
		} catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin	"
		}

    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			resena: new Resena().get(id), 
			resenas: Resena.list()
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def resenas = Resena.list()

		render(view: 'index', 
			model: [
				resenas:resenas
			]
		)
    }

	/* save */
	def save(Resena resena) {

		try {
		
			resenaService.save(resena)
			redirect action:"edit", id:resena.id			

		} catch (UserRegistrationException error) {        

			flash.message = error.message        
			redirect controller: 'usuario', action:"newlogin	"

		} catch (ResenaException error) {        

			flash.message = error.message 
			respond view:'create', [model:error.model]
			return
		}
	    
    }


}
