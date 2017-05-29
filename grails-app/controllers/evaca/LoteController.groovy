package evaca

class LoteController {

	/* create */
	def create() {
	
	    def model = [
			lote: new Lote(params), 
			lotes: Lote.list()
		]

		[model: model]
    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			lote: new Lote().get(id), 
			lotes: Lote.list()
		]

		respond view:'create', [model:model]
    }

	/* index */
	def index() {

		def lotes = Lote.list()

		render(view: 'index', 
			model: [
				lotes:lotes
			]
		)
    }

	/* save */
	def save(Lote lote) {
	
		if (!params.id){
			lote = new Lote(params)
		}
		
		lote.save(flush:true)

		def model = [
			lote: lote, 
			lotes: Lote.list()
		]

		if (lote.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:lote.id
	    
    }


}
