package evaca

class AvisoController {

	/* create */
	def create() {
	
	    def model = [
			aviso: new Aviso(params), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]
		
		// render model.aviso
		// return
		[model: model]
    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			aviso: new Aviso().get(id), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]

		respond view:'create', [model:model]
    }

	/* index */
	def index() {

		def avisos = Aviso.list()

		render(view: 'index', 
			model: [
				avisos:avisos
			]
		)
    }

	/* save */
	def save(Aviso aviso) {
	
		if (!params.id){
			aviso = new Aviso(params)
		}

		aviso.save(flush:true)

		def model = [
			aviso: aviso, 
			avisos: Aviso.list(),
			categorias: Categoria.list(),
			razas: Raza.list()
		]

		if (aviso.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:aviso.id
	    
    }
	
	/* show */
	def show() {

		def avisos = Aviso.list()

		render(view: 'show', 
			model: [
				avisos:avisos
			]
		)
    }


}
