package evaca

class AvisoController {

	static scaffold = Aviso
	
	/* index */
	def index() {
	
		def avisos = Aviso.list()

		render(view: 'index', 
			model: [
				avisos:avisos
			]
		)
    }
}
