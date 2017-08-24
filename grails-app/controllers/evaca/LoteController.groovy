package evaca

import org.springframework.core.io.Resource

class LoteController 
	extends BaseController 
	implements ImageHandler
	
	{
	
	def loteService
	def uploadRestaurantFeaturedImageService
	def grailsResourceLocator


	/* admin */
	def admin() {		
		respond (
			view:'admin', 
			getViewModel(loteService.edit(params.id))
		)
    } 
	

	/* create */
	def create() {		    
		respond (
			view:'create', 
			getViewModel(loteService.create())
		)
    }

	
	/* edit */
	def edit() {	
		println "edit"
		respond (
			view: 'create', 
			getViewModel(loteService.edit(params.id))
		)
    }


	/* search */
	def search() {	

		render(
			view: 'search', 
			model: [
				lotes : loteService.search(params)			
			]	
		)
    }


	/* save */
	def save(Lote lote) {
	// def save(SaveCommand cmd) {

		try {

			loteService.save(lote)
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id
 
		} catch (LoteException e){

			flash.message = e.message
			render(view: 'create', model:getViewModel(lote))
			return
		}
	    
    }
	
	
	/* getViewModel */ 
	def getViewModel(Lote lote){

		[
			lote: lote, 
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]
	}
	
	/* get_image */ 
	def get_image(Lote lote) { 
	 
		// @Autowired
		// def grailsResourceLocator
 
        if (lote == null) {
			render "no-img"
            return
        }
		
		println "----"
		println grailsResourceLocator
		println "----"
		
		if (lote.image == null) {
			final Resource image = grailsResourceLocator.findResourceForURI('/sham/img/users/anon.png')
			render (file: image.inputStream, contentType: '')
            return
        }
		
		render (file: lote.image, contentType: '')
		return
    }
	
}
