package evaca



/* Aviso */	
class Aviso {

	Date fechaCreacion
	// Date fechaPublicacion
	
    Date dateCreated
    Date lastUpdated

	Float precio
	AvisoState tbState
	Usuario consignatario
	Lote lote     

	static belongsTo = [lote:Lote, consignatario:Usuario]	
	static hasMany = [ofertas: Oferta]
	
	
	
	/* constraints */
	static constraints = {

		// fechaCreacion nullable: true
		// fechaPublicacion nullable: true
		// tbState nullable: true, inList: ['Borrador', 'Publicado', 'Vendido'] 

		// validator: {val, obj ->
			// if (val == 'Publicado') {
				// if (obj.lote.tbState != '') {
					// throw new DomainException(message : "No publicar")
				// }
			// }
		// }

		// consignatario (validator: AvisoValidator.consignatario)
		
		tbState nullable: true		
		consignatario nullable: true		
		lote nullable: true
		precio nullable: false

	}
	
	/* mapping */
    static mapping = {
		tbState lazy: false
    }
	
	/* Aviso() */
	public Aviso() {
		this.fechaCreacion = new Date();
		this.tbState = AvisoState.BORRADOR;
		
		// println "previaSetPrecio"
		this.precio = null
		this.consignatario = null
		this.lote = null
	}

	/* setPrecio */
	public void _setPrecio(Float precio){
		// println "setPrecio"
		if (this.tbState == AvisoState.VENDIDO){
			throw new DomainException(message : "No puede cambiar un aviso VENDIDO")
		}
		this.precio = precio
	}
	
	public void _setTbState(AvisoState tbState){ /* si lo desactivo arruino el gorm */
	}

	/* changeState */
	public changeState(AvisoState tbState, Usuario ejecutor){
	
		/* roles */
		println ejecutor
		println ejecutor?.tbTipo
		if (ejecutor.tbTipo != 'Administrador'){
			throw new DomainException(message:"You must be Admin to perform this action")
		}		
		
		/* state flow */		
		println "setTbState: " + tbState
		println "this.setTbState: " + this.tbState
		println "this.lote.tbState: " + this.lote.tbState

		if (this.tbState == AvisoState.VENDIDO){
			throw new DomainException(message : "No puede cambiar un aviso VENDIDO")
		}

		if (this.tbState == AvisoState.CANCELADO){
			throw new DomainException(message : "No puede cambiar un aviso CANCELADO")
		}
		
		tbState.validateStateFlow(this);

	}

	/* setConsignatario */
	public void _setConsignatario(Usuario consignatario){

		if (this.tbState == AvisoState.VENDIDO || this.tbState == AvisoState.PUBLICADO || this.tbState == AvisoState.CANCELADO){
			throw new DomainException(message : "No puede cambiar un aviso VENDIDO")
		}
		this.consignatario = consignatario
	}
	
	/* setLote */
	public void setLote(Lote lote){

		if (this.tbState == AvisoState.VENDIDO){
			throw new DomainException(message : "No puede cambiar un aviso VENDIDO")
		}
		this.lote = lote
	}
	
	/* beforeInsert() */
	def beforeInsert() {
		// this.fechaCreacion = new Date()
	}
	
	/* setConsignatario() */
	// public void setConsignatario(Usuario consignatario){
		// AvisoValidator.consignatario(consignatario)
		// this.consignatario = consignatario
	// }

	
	/* setLote() */
	// public void setLote(Lote l){

		// if (l.tbState != 'Borrador'){
			// throw new DomainException(message : "El lote no está Disponible")
		// }

		// lote = l
		// // lote.tbState = 'Avisado'
	// }

	String toString(){
		this.tbState + this.precio + this.consignatario
	}


}
