package evaca

class LoteController {

	// static scaffold = Lote
	
	def create() {
		Lote l = new Lote();
		l.usuario = Usuario.list()[2]
        respond([lote:l]) 
	}
	
	/* edit */
	def edit(Lote lote) {
        respond lote
    }
	
	/* show */
	def show(Lote lote) {
        respond lote
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

}
