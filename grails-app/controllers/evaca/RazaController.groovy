package evaca

class RazaController {

	/* create */
	def create() {
	
	    def model = [
			raza: new Raza(params), 
			razas: Raza.list()
		]

		[model: model]
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
	
		if (!params.id){
			raza = new Raza(params)
		}
		
		raza.save(flush:true)

		def model = [
			raza: raza, 
			razas: Raza.list()
		]

		if (raza.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:raza.id
	    
    }


}
