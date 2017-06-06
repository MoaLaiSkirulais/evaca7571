package evaca

class LoteController {

	/* create */
	def create() {
	
	    def model = [
			lote: new Lote(params), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]

		[model: model]
    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			lote: new Lote().get(id), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
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
	
		// render "<p>lote: " + lote + "</p>"
		// render "<p>lote.raza: " + lote.raza + "</p>"
		// render "<p>lote.raza.id: " + lote.raza.id + "</p>"
		// render "<p>lote.categoria.id: " + lote.categoria.id + "</p>"
		// render "<p>lote.id: " + lote.id
		// return
	
		if (!params.id){
			lote = new Lote(params)
		}

		lote.save(flush:true)

		def model = [
			lote: lote, 
			lotes: Lote.list(),
			categorias: Categoria.list(),
			razas: Raza.list()
		]

		if (lote.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:lote.id
	    
    }


}
