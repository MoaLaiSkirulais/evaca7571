package evaca

class LoteController extends BaseController{
	
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
	
		try {

			loteService.save(lote)
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id

		}  catch (UsuarioException error) {
		
			flash.message = "Mal"
			render(view: 'create', model: error.model)
			println "UsuarioException"
		}
	    
    }


}
