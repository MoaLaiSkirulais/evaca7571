package evaca

class AvisoController {
	
	def ofertaService

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

		def id=params.id
		render(view: 'show', 
			model: [
				aviso: new Aviso().get(id),
				plazos: Plazo.list()
			]
		)
    }
	
	/* ofertar */
	def ofertar(Oferta oferta) {		
		ofertaService.save(oferta)
		redirect action:"show", id:oferta.aviso.id 
		// render oferta.aviso.id 
    }
	
	/* exception */
	def exception(UserRegistrationException error) {
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	/* exception */
	def exception(OfertaException error) {
		flash.message = "error"
		render error.model.oferta.aviso
		def model = [
				aviso: error.model.oferta.aviso,
				plazos: Plazo.list()
			]
		respond view:'show', [model:model]
    }


}
