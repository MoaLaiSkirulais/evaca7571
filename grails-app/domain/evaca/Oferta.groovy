package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	Plazo plazo
	Float precio
	String tbState
	Venta venta //analizar

	static belongsTo = [aviso:Aviso, usuario:Usuario, plazo:Plazo]
	
	
	
	/* Oferta() */
	public Oferta() {
		this.fechaCreacion = new Date();
		this.tbState = 'Aprobacion';
	}

	
	
	/* constraints */
    static constraints = {
		tbState nullable: true, inList: ['Aprobacion', 'Vigente', 'Rechazada', 'Aceptada', 'Cancelada']
		venta nullable: true
    }

	
	
	/* aceptar() */
	public aceptar(Usuario usuario) {

		if (this.aviso.lote.usuario.equals(usuario)){
			throw new DomainException(message: "Solo el vendedor puede aceptar la oferta")
		}

		if (this.tbState != 'Activa'){
			throw new DomainException(message:"La oferta no está Activa")
		}
		
		this.tbState = 'Aceptada'
		return this
	}	

	
	
	/* activar() */
	public activar(Usuario usuario) {
		
		if (usuario.tbTipo != 'Administrador'){
			throw new DomainException(message:"Solo un administrador puede aprobar la oferta")
		}
		
		if (this.tbState != 'Pendiente'){
			throw new DomainException(message:"La oferta no está Pendiente")
			}
		
		this.tbState = 'Activa'
		return this
	}

	
	
	/* cancelar() */
	public cancelar(Usuario usuario) {

		if (Usuario.tbTipo != 'Administrador' || this.usuario!=usuario){
			throw new DomainException(message: "Sólo un administrador o el comprador puede cancelar la oferta")
		}
		
		if (this.tbState != 'Activa'){
			throw new DomainException(message:"La oferta no está Activa")
		}
	}

	
	
	/* rechazar() */
	public rechazar(Usuario usuario) {
		
		if (this.aviso.lote.usuario.equals(usuario)){
			throw new DomainException(message: "Solo el vendedor puede rechazar la oferta")
		}

		if (this.tbState != 'Activa'){
			throw new DomainException(message:"La oferta no está Activa")
		}
		
		this.tbState = 'Rechazada'
		return this
	}



	/* setTbState() */
	public void setTbState(String tbState){

		if (tbState == 'Aprobacion'){
			if (this.tbState=='Rechazada' || this.tbState=='Aceptada' || this.tbState=='Vigente' || this.tbState=='Cencelada'){
				throw new DomainException(message : "La ya no puede ir a Aprobacion")
			}
		}

		if (tbState == 'Vigente'){
			if (this.tbState != 'Aprobacion'){
				// throw new DomainException(message : "La oferta no está Aprobacion")
			}
			
			if (this.aviso.tbState != 'Publicado'){
				throw new DomainException(message : "El aviso no está Publicado")
			}
			
		}

		if (tbState == 'Rechazada'){
			if (this.tbState != 'Vigente'){
				throw new DomainException(message : "La oferta no está Vigente")
			}
		}

		if (tbState == 'Aceptada'){
			if (this.tbState != 'Vigente'){
				throw new DomainException(message : "La oferta no está Vigente")
			}
			this.aviso.tbState = 'Vendido'

			/* genero la venta */
			this.venta = new Venta(
				oferta: this, 
				fechaCreacion: new Date()
			)
		}

		if (tbState == 'Cancelada'){
			if (this.tbState != 'Vigente'){
				throw new DomainException(message : "La oferta no está Vigente")
			}
		}

		this.tbState = tbState
		
	}

	// /* setTbState() */
	// public setTbState(String tbState) {
		// println "tbState!!"
		// println this.tbState		
		// tbState = tbState
	// }
	
	/* setPrecio() */
	// public setPrecio(Float p) {
		// println "precio!!"
		// this.precio = p
		// println this.precio
	// }

	// /* getPrecio() */
	// public getPrecio() {
		// return this.precio
	// }

	
}