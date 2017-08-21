package evaca

class LoteController extends BaseController implements LoteExceptionHandler{
	
	def loteService
	def uploadRestaurantFeaturedImageService
	def usuarioService


	/* admin */
	def admin() {		
		respond (view:'admin', getViewModel(loteService.edit(params.id)))		
    } 
	

	/* create */
	def create() {		    
		respond view:'create', getViewModel(loteService.create())
    }

	
	/* edit */
	def edit() {	
		respond view:'create', getViewModel(loteService.edit(params.id))
    }


	/* search */
	def search() {	

		render(
			view: 'search', 
			model: [
				usuario: usuarioService.edit(1), 
				lotes : loteService.search(params)			
			]	
		)
    }


	/* save */
	def save(Lote lote) {

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
			usuario: usuarioService.edit(1), 
			lote: lote, 
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]
	}
 


}
