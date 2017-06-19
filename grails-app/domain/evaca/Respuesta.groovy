package evaca

class Respuesta {
	
	Pregunta pregunta
	Resena resena
	String respuesta
	Integer puntaje	
	
	static belongsTo = [resena:Resena] 

	static constraints = {
		respuesta(nullable:true, blank:true)
	}

}
