package evaca

class LoteController extends BaseController implements LoteExceptionHandler{
	
	def loteService

	/* create */
	def create() {		    
		respond view:'create', getViewModel(loteService.create())
    }

	
	/* edit */
	def edit() {	
		respond view:'create', getViewModel(loteService.edit(params.id))
    }


	/* index */
	def index() {	
	
		// render params
		// render params?.usuario?.id
		// return 
		
		render(
			view: 'index', 
			model:loteService.search(params)
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
			lote: lote, 
			categorias: Categoria.list(),
			razas: Raza.list()
		]
	}


}
