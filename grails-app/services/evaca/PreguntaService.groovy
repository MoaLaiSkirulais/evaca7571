package evaca


class PreguntaService {
	
	def mySessionService
	
	
	/* create */
	def create() {
		new Pregunta(usuario:mySessionService.usuario)
	}
	
	
	/* edit */
	def edit(id) {

		def pregunta = new Pregunta().get(id)
		if (!pregunta){
			throw new PreguntaException()
		}

		return pregunta
	}
	

	/* save */
	def save(Pregunta pregunta) {
	
		pregunta.save(flush:true, failOnError: false)
		if (pregunta.hasErrors()) {
			throw new PreguntaException();
		}
		return pregunta
		
	}		
	
	
	/* search */
	def search() {
	
		def preguntas = Pregunta.list()
		return  [preguntas : preguntas]

	}			

	
}
