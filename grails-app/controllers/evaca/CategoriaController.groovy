package evaca

class CategoriaController {

	/* create */
	def create() {
	
	    def model = [
			categoria: new Categoria(params), 
			categorias: Categoria.list()
		]

		[model: model]
    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			categoria: new Categoria().get(id), 
			categorias: Categoria.list()
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
	def save(Categoria categoria) {
	
		if (!params.id){
			categoria = new Categoria(params)
		}
		
		categoria.save(flush:true)

		def model = [
			categoria: categoria, 
			categorias: Categoria.list()
		]

		if (categoria.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:categoria.id
	    
    }


}
