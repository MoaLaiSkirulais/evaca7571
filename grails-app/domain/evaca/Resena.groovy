package evaca

class Resena {
	
	Date fechaCreacion
	Integer puntaje	
	Venta venta
	Usuario usuario
	List<Respuesta> respuestas

	static belongsTo = [venta:Venta, usuario:Usuario] 
	static hasMany = [respuestas: Respuesta]

	/* Resena */
	public Resena() {
	
		this.respuestas = []
		this.fechaCreacion = new Date();		
	}
	
	/* prepare() */
	public prepare() {

		def preguntas = Pregunta.list()
		preguntas.collect { pregunta ->
			println pregunta
			def respuesta = new Respuesta()
			respuesta.pregunta = pregunta
			respuesta.respuesta="Todo bien"
			respuesta.resena = this
			this.addToRespuestas(respuesta)
		}
	}

	/* constraints */
	static constraints = {

		fechaCreacion()
		puntaje min:1, max:5
		venta()
		usuario()
	}
}
