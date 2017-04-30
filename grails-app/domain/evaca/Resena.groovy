package evaca

class Resena {
	
	Date fechaCreacion
	Integer puntaje
	String comentario
	
	Venta venta
	Usuario usuario
	
	Integer respuesta1
	Integer respuesta2
	Integer respuesta3
	Integer respuesta4
	Integer respuesta5
	
	
	static belongsTo = [venta:Venta, usuario:Usuario] 
	// static hasMany = [preguntas: Pregunta]
	// static hasMany = [resenaPreguntas: ResenaPregunta]
  static mapping = {
        comentario type: "text"
    }

	
	static constraints = {
	
		fechaCreacion()
		puntaje min:1, max:5
		comentario()	
		venta()
		usuario()
		
		
		
		respuesta1 min:1, max:5
		respuesta2 min:1, max:5
		respuesta3 min:1, max:5
		respuesta4 min:1, max:5
		respuesta5 min:1, max:5
	}
}
