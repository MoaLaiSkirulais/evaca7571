package evaca

class OfertaController {

	static scaffold = Oferta
	
	/* index */
	def index() {
	
		def ofertas = Oferta.list()

		render(view: 'index', 
			model: [
				ofertas:ofertas
			]
		)
    }
}
