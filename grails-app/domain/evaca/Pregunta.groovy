package evaca

class Pregunta {
	
	Usuario usuario
	Date fechaCreacion
	String label
	
	static hasMany = [resenaPreguntas: ResenaPregunta]

	static constraints = {
	}
	
	public Pregunta() {
		this.fechaCreacion = new Date();
	}
}
