package evaca

class PreguntaController {
	
	def preguntaService

	/* create */
	def create() {
		preguntaService.create()
    }

	
	/* edit */
	def edit() {
		def model = preguntaService.edit(params.id)
		respond view:'create', model		
    }
	
	
	/* index */
	def index() {	
		render(view: 'index', model:preguntaService.search())
    }


	/* save */
	def save(Pregunta pregunta) {

		preguntaService.save(pregunta)
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:pregunta.id
	    
    }


}
