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
	
		def avisos = Aviso.createCriteria().list (params) {

			if (params?.consignatario?.nombre) {
				'consignatario'{ilike('nombre', "%${params.consignatario.nombre}%")}
				 // between("fechaCreacion", "01/01/2011", "01/01/2011")
			}

		}
   
		render(view: 'index', 
			model: [
				avisos:avisos,
				lote:[categorias: Categoria.list().sort{it.nombre}],
				lote:[razas: Raza.list().sort{it.nombre}]
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
		println "error"
		ofertaService.save(oferta)
		redirect action:"show", id:oferta.aviso.id 
		// render oferta.aviso.id 
    }
	
	/* exception */
	def exception(UserRegistrationException error) {
		println "UserRegistrationException"
		// render "pija"
		// return
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	/* exception */
	def exception(OfertaException error) {
		println "OfertaException"
		// render "pija"
		// return
		flash.message = "error"
		render error.model.oferta.aviso
		def model = [
				aviso: error.model.oferta.aviso,
				plazos: Plazo.list()
			]
		respond view:'show', [model:model]
    }


}
