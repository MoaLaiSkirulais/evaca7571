package evaca

class LoteController extends BaseController implements LoteExceptionHandler{
	
	def loteService

	/* create */
	def create() {	
	    loteService.create()
    }

	
	/* edit */
	def edit() {	
		respond view:'create', loteService.edit(params.id)		
    }


	/* index */
	def index() {	
		render(view: 'index', model:loteService.search())
    }


	/* save */
	def save(Lote lote) {
	
		loteService.save(lote)		
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:lote.id
	    
    }


}
