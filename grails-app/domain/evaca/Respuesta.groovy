package evaca

class Respuesta {
	
	Pregunta pregunta
	Resena resena
	String respuesta
	Integer puntaje	
	
	static belongsTo = [resena:Resena] 

	static constraints = {
		puntaje(nullable:true, blank:true, min:1, max:5)
	}

}
