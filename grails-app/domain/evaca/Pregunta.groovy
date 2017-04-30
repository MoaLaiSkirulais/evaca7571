package evaca

class Pregunta {
	
	Date fechaCreacion
	String label
	
	static hasMany = [resenaPreguntas: ResenaPregunta]

	static constraints = {
	}
}
