package evaca

/* 
 * Aviso
 */

class Aviso {

	Date fechaCreacion
	Date fechaPublicacion
	Float precio
	String tbState
	Usuario consignatario
	Lote lote     
	
	static belongsTo = [lote:Lote, consignatario:Usuario]	
	static hasMany = [ofertas: Oferta]
	static constraints = {

		fechaCreacion nullable: true
		fechaPublicacion nullable: true
		tbState nullable: true, inList: ['Borrador', 'Publicado', 'Vendido']
	}
	
	/* beforeInsert() */
	def beforeInsert() {
		this.fechaCreacion = new Date()
	}
	
	/* Aviso() */
	public Aviso() {
		this.fechaCreacion = new Date();
		this.tbState = 'Borrador';
	}

	/* setLote() */
	public void setLote(Lote l){

		if (l.tbState != 'Disponible'){
			throw new DomainException(message : "El lote no está Disponible")
		}

		lote = l
		// lote.tbState = 'Avisado'
	}

	/* setLote() */
	public void setTbState(String tbState){

		if (tbState == 'Publicado'){
			if (this.tbState != 'Borrador'){
				throw new DomainException(message : "El aviso no está Borrador")
			}
		}
		
		if (tbState == 'Vendido'){
			if (this.tbState != 'Publicado'){
				throw new DomainException(message : "El aviso no está Publicado")
			}
		}

		this.tbState = tbState
		
	}


	// String toString(){
		// this.tbState + this.precio + this.consignatario
	// }
	
    // public void setTbState(String tbState) {
		// if (tbState == 'Active'){
			// this.tbState = 'Finished'
		// } else {
			// this.tbState = tbState
		// }
    // }

}
