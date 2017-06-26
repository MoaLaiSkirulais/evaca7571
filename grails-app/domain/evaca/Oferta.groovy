package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	Plazo plazo
	Float precio
	String tbState

	static belongsTo = [aviso:Aviso, usuario:Usuario, plazo:Plazo]
	
	/* Oferta() */
	public Oferta() {
		this.fechaCreacion = new Date();
		this.tbState = 'Pendiente';
	}

	/* constraints */
    static constraints = {
		tbState nullable: true, inList: ['Pendiente', 'Activa', 'Rechazada', 'Aceptada', 'Cancelada']
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