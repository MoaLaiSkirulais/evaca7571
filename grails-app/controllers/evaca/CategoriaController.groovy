package evaca

class CategoriaController {
	
	def categoriaService

	/* create */
	def create() {
	
		try {
			
			categoriaService.create()
		
		} catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin	"
		}

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

		def categorias = Categoria.list()

		render(view: 'index', 
			model: [
				categorias:categorias
			]
		)
    }

	/* save */
	def save(Categoria categoria) {
	
		println "pija1"

		try {
		
			println "pija2"
			println categoria
			categoriaService.save(categoria)
			redirect action:"edit", id:categoria.id			

		} catch (UserRegistrationException error) {        

			flash.message = error.message        
			redirect controller: 'usuario', action:"newlogin	"

		} catch (CategoriaException error) {        

			println "pija3"
			flash.message = error.message 
			respond view:'create', [model:error.model]
			return
		}
	    
    }


}
