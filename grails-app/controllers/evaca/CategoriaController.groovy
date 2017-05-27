package evaca

class CategoriaController {


	/* edit */
	def edit(Categoria categoria) {
        respond categoria
    }
	
	/* create */
	def create() {
        // respond new Categoria(params)
		render(view: 'edit', 
			model: [
				categoria:new Categoria(params)
			]
		)
    }
	
	/* save */
	def save = {
	
        def categoria = Categoria.get(params[id])
		if (categoria) {
            render "<h1>1</h1>"
			return
        } else {
			render "<h1>2</h1>"
			return
		}

	
        // def categoria = new Categoria(params)
        // if (categoria.validate() && categoria.save()) {
            // redirect action:"edit", id:categoria.id
        // } else {  
            // render view:"edit", model:[categoria:categoria]
        // }
    }
	
	/* update */
	def update(Categoria categoria) {
        if (categoria == null) {
            notFound()
            return
        }

        if (categoria.hasErrors()) {
            respond categoria.errors, view:'create'
            return
        }

        categoria.save flush:true
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
}
