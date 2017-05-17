package evaca

class ResenaController {

	static scaffold = Resena
	
	/* index */
	def index() {

		render(view: 'index', 
			model: [
				resenas : Resena.list()
			]
		)
    }
}
