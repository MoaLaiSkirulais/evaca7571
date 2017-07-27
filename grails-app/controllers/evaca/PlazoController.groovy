package evaca

class PlazoController extends BaseController implements PlazoExceptionHandler {
	
	def plazoService

	/* create */
	def create() {
		plazoService.create()
    }

	
	/* edit */
	def edit() {	
		def model = plazoService.edit(params.id)
		respond view:'create', model		
    }
	

	/* index */
	def index() {	
		render(view: 'index', model:plazoService.search())
    }
		

	/* save */
	def save(Plazo plazo) {
	
		plazoService.save(usuario)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:plazo.id	    
    }


}
