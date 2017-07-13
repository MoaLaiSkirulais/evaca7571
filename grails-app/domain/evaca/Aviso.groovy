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
	public changeState(AvisoState tbState){
		
		println "setTbState: " + tbState
		println "this.setTbState: " + this.tbState
		println "this.lote.tbState: " + this.lote.tbState

		if (this.tbState == AvisoState.VENDIDO){
			throw new DomainException(message : "No puede cambiar un aviso VENDIDO")
		}

		if (this.tbState == AvisoState.CANCELADO){
			throw new DomainException(message : "No puede cambiar un aviso CANCELADO")
		}

		switch (tbState) {

			/* Borrador */
			case AvisoState.BORRADOR:

				if (this.tbState == AvisoState.PUBLICADO || this.tbState == AvisoState.APROBACION ){
					throw new DomainException(message : "No puede volver a BORRADOR")
				}
				this.tbState = tbState
				break
	
			/* Aprobacion */
			case AvisoState.APROBACION:

				throw new DomainException(message : "No puede pasarse a APROBACION manualmente")
				break
			
			/* Cancelado */
			case AvisoState.CANCELADO:
			
				this.tbState = tbState
				break
	
			/* Rechazado */
			case AvisoState.RECHAZADO:

				if (this.tbState != AvisoState.APROBACION){
					throw new DomainException(message : "El aviso no está en APROBACION")
				}
				this.tbState = AvisoState.BORRADOR
				return

			/* Vendido */
			case AvisoState.VENDIDO:

				if (this.tbState != AvisoState.PUBLICADO){
					throw new DomainException(message : "El aviso no esta PUBLICADO")
				}
				this.tbState = tbState
				break

			/* Publicado */
			case AvisoState.PUBLICADO:	
			
				/* en borrador? */
				if (this.tbState == AvisoState.BORRADOR){
					this.tbState = AvisoState.APROBACION
					return;
				}
				
				/* está aprobado? */
				if (this.tbState != AvisoState.APROBACION){
					throw new DomainException(message : "El aviso no está en APROBACION")
				}				

				/* lote disponible? */
				if (this.lote.tbState != LoteState.DISPONIBLE){
					throw new DomainException(message : "Lote no disponible")
				}

				/* publíquese */
				this.lote.tbState = LoteState.OCUPADO //esto puede delegarse
				this.tbState = tbState
				break
		}

		
	}

	/* setConsignatario */
	public void setConsignatario(Usuario consignatario){

		if (this.tbState == AvisoState.VENDIDO){
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

	/* setTbState() */
	// public void setTbState(String tbState){

		// if (tbState == 'Publicado'){
			// if (this.tbState != 'Borrador'){
				// throw new DomainException(message : "El aviso no está Borrador")
			// }
		// }

		// if (tbState == 'Vendido'){
			// if (this.tbState != 'Publicado'){
				// throw new DomainException(message : "El aviso no está Publicado")
			// }
			
			// this.lote.tbState = 'Vendido'
			
		// }

		// this.tbState = tbState
		
	// }

	// String toString(){
		// this.tbState + this.precio + this.consignatario
	// }


}
