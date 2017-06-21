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
	
		// params.max = Math.min(params.max ? params.int('max') : 10, 100)
			// [taskInstanceList: Task.list(params), taskInstanceTotal: Task.count()]
		// }
		
		def razas = Raza.createCriteria().list (params) {
            // if (params.nombre) {
                // ilike("nombre", "%${params.nombre}%")
            // }
			
            ilike("nombre", "%${params.nombre}%")
			'usuario'{ilike('nombre', "%${params.usuario.nombre}%")}
        }
 



		// def razas = Raza.list()

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

		} catch (UserRegistrationException error) {        

			flash.message = error.message        
			redirect controller: 'usuario', action:"newlogin	"

		} catch (RazaException error) {        

			flash.message = error.message 
			respond view:'create', [model:error.model]
			return
		}
	    
    }


}
