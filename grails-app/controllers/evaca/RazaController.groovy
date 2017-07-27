package evaca

class RazaController extends BaseController implements RazaExceptionHandler {
	
	def razaService

	/* create */
	def create() {
		razaService.create()
    }

	
	/* edit */
	def edit() {	
		def model = razaService.edit(params.id)
		respond view:'create', model		
    }
	

	/* index */
	def index() {	
		render(view: 'index', model:razaService.search())
    }
		

	/* save */
	def save(Raza raza) {
	
		razaService.save(raza)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:raza.id	    
    }


}
