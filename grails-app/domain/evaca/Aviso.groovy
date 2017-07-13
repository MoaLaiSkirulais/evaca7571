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

		switch (tbState) {

			case AvisoState.BORRADOR:

				if (this.tbState == AvisoState.PUBLICADO || this.tbState == AvisoState.APROBACION ){
					println "No puede volver a BORRADOR"
					throw new DomainException(message : "No puede volver a BORRADOR")
				}
				break
	
			case AvisoState.APROBACION:

				throw new DomainException(message : "No puede pasarse a APROBACION")
				break
	
			case AvisoState.VENDIDO:

				if (this.tbState != AvisoState.PUBLICADO){
					println "El aviso no esta PUBLICADO"
					throw new DomainException(message : "El aviso no esta PUBLICADO")
				}
				break

			case AvisoState.PUBLICADO:	
			
				/* en borrador? */
				if (this.tbState == AvisoState.BORRADOR){
					println "en borrador"
					this.tbState = AvisoState.APROBACION
					return;
				}

				// /* en aprobacion? */
				// if (this.tbState != AvisoState.APROBACION){
					// println "No puede publicar un aviso no APROBACION"
					// throw new DomainException(message : "No puede publicar un aviso no APROBACION")
				// }

				/* lote esta dispponible? */
				if (this.lote.tbState != LoteState.DISPONIBLE){
					println "Lote no disponible"
					throw new DomainException(message : "Lote no disponible")
				}

				/* publicado */
				this.lote.tbState = LoteState.OCUPADO //esto puede delegarse
				break
		}

		this.tbState = tbState
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
