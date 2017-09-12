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


	/** 
	 * Resena 
	 */
	public Resena() {
	
		this.respuestas = []
		this.fechaCreacion = new Date();		
		this.state = ResenaState.BORRADOR;
	}

	
	/** 
	 * prepare() 
	 */
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


	/** 
	 * constraints 
	 */
	static constraints = {
	
		// venta(unique: ['usuario'])

		fechaCreacion()
		puntaje min:1, max:5
		venta()
		// propietario unique: 'venta' /* esta restriccion no sirve para cuando varios pueden entregar resenas*/

	}
	
	
	/** 
	 * postular() 
	 */
	public postular(Usuario ejecutor) {
	
		/* hay que validar que la venta existe*/
		
		/* hay que validar solo 3 reseñas posibles */

		if (this.state != ResenaState.BORRADOR) { 
			throw new ResenaException(message : "La resena no está en BORRADOR")
		}
		
		if (this.propietario != ejecutor){
			throw new ResenaException(message: "Solo el dueño de la reseña puede postular")
        }
		
		this.state = ResenaState.POSTULADO
	}

	
	/** 
	 * aprobar() 
	 */
	public aprobar(Usuario ejecutor) {
	
		
		/* está aprobado? */
		if (this.state == ResenaState.APROBADO){
			throw new ResenaException(message : "La reseña ya está aprobada")
		}				
	
		/* está postulado? */
		if (this.state != ResenaState.POSTULADO){
			throw new ResenaException(message : "La reseña no está postulada")
		}
		
		/* admin? */
		if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new ResenaException(message: "Se necesita un administrador para ejecutar esta accion")
		}			
		
		/* es dueño del vendedor, comprador o consignatario?
			para esto tengo que llegar al aviso y oferta desde acá */
		
		this.state = ResenaState.APROBADO
	}

	
	/** 
	 * desaprobar() 
	 */
	public desaprobar(Usuario ejecutor) {
	
		/* ya lo está? */
		if (this.state != ResenaState.POSTULADO){
			throw new ResenaException(message : "La resena no está en POSTULADO")
		}			

		/* admin? */
		if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new ResenaException(message: "Se necesita un administrador para ejecutar esta accion")
		}			
	
		this.state = ResenaState.DESAPROBADO
	}

	
	/* changeState */
	public changeState(ResenaState state, Usuario ejecutor){
		// state.validateStateAccess(this, ejecutor)
		// state.validateStateFlow(this)
		// this.state = state

	}
}
