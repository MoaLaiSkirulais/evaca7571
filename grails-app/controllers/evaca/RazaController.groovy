package evaca

class RazaController {
	
	def razaService

	/* create */
	def create() {
		
		try {
			
			razaService.create()
		
		} catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin	"
		}

    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			raza: new Raza().get(id), 
			razas: Raza.list()
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def razas = Raza.list()

		render(view: 'index', 
			model: [
				razas:razas
			]
		)
    }

	/* save */
	def save(Raza raza) {
	
		try {
			
			razaService.save(raza)
			redirect action:"edit", id:raza.id

		} catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			respond view:'create', [model:ure.model]
			return
		}

		// if (!params.id){
			// raza = new Raza(params)
		// }
		
		// raza.save(flush:true)

		// def model = [
			// raza: raza, 
			// razas: Raza.list()
		// ]

		// if (raza.hasErrors()) {
			// respond view:'create', [model:model]
			// return
		// }

		// redirect action:"edit", id:raza.id
	    
    }


}
