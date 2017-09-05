package evaca

class Resena {
	
	Date fechaCreacion
	Integer puntaje	
	Venta venta
	Usuario propietario
	List<Respuesta> respuestas /* esto es genial tener muy en cuenta, es ofertas che */
	ResenaState state

	static belongsTo = [venta:Venta, propietario:Usuario] 
	static hasMany = [respuestas: Respuesta]


	/* Resena */
	public Resena() {
	
		this.respuestas = []
		this.fechaCreacion = new Date();		
		this.state = ResenaState.BORRADOR;
	}

	
	/* prepare() */
	public prepare() {

		def preguntas = Pregunta.list()
		preguntas.collect { pregunta ->

			def respuesta = new Respuesta()
			respuesta.pregunta = pregunta
			respuesta.respuesta = "Todo bien"
			respuesta.puntaje = 1
			respuesta.resena = this
			this.addToRespuestas(respuesta)
		}
	}


	/* constraints */
	static constraints = {
	
		// venta(unique: ['usuario'])

		fechaCreacion()
		puntaje min:1, max:5
		venta()
		propietario unique: 'venta'
		

	}
	
	
	/* postular() */
	public postular(Usuario ejecutor) {
	
		/* hay que validar que la venta existe*/
		
		/* hay que validar solo 3 reseñas posibles */

		if (this.state != ResenaState.BORRADOR) { 
			throw new ResenaException(message : "La resena no está en BORRADOR")
		}
		
		if (this.propietario != ejecutor){
			throw new ResenaException(message: "Solo el dueño del resena puede pedir aprobacion")
        }
		
		this.state = ResenaState.POSTULADO
	}

	
	/* changeState */
	public changeState(ResenaState state, Usuario ejecutor){
		// state.validateStateAccess(this, ejecutor)
		// state.validateStateFlow(this)
		// this.state = state

	}
}
