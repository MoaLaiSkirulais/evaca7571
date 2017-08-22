package evaca

class PlazoController extends BaseController implements PlazoExceptionHandler {
	
	def plazoService
	def usuarioService
	
 
	/* create */
	def create() {
		plazoService.create()
    }

	
	/* edit */
	def edit() {	
		def model = 
		render (
			view: 'create', 
			model:[ 
				usuario: usuarioService.edit(1), 
				plazo: plazoService.edit(params.id)
			]
		)
    }
	

	/* search */
	def search() {	
		render(
			view: 'search', 
			model: [
				usuario: usuarioService.edit(1), 
				plazos: plazoService.search()
			]
		)
    }
		

	/* save */
	def save(Plazo plazo) {
	
		plazoService.save(plazo)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:plazo.id	    
    }


}
