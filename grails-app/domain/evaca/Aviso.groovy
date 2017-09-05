package evaca


/* Aviso */	
class Aviso {

	Date fechaCreacion	
	Float precio
	AvisoState state
	Usuario propietario
	Usuario consignatario
	Lote lote     

	static belongsTo = [lote:Lote, propietario:Usuario, consignatario:Usuario]	
	static hasMany = [ofertas: Oferta]


	/* constraints */
	static constraints = {

		state nullable: false
		consignatario nullable: true
		lote nullable: false
		precio nullable: true
		// lote : { val, obj ->
			// obj.propietario == val.usuario
		// }

	}
	
	
	/* mapping */
    static mapping = {
		// state lazy: false
    }
	
	
	/* Aviso() */
	public Aviso() {
		this.fechaCreacion = new Date();
		this.state = AvisoState.BORRADOR;		
	}


	/* changeState */
	public changeState(AvisoState state, Usuario ejecutor){
		// state.validateStateAccess(this, ejecutor);
		// state.validateStateFlow(this);
		// this.state = state
	}


	/* aprobar */
	public aprobar(Usuario ejecutor){
		
		/* está aprobado? */
		if (this.state == AvisoState.APROBADO){
			throw new AvisoException(message : "El aviso ya está APROBADO")
		}
		
		/* está postulado? */
		if (this.state != AvisoState.POSTULADO){
			throw new AvisoException(message : "El aviso no está POSTULADO")
		}
		
		/* admin */
		if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new AvisoException(message: "Se necesita un administrador para ejecutar esta accion")
		}
		
		/* aprueba dueño? */
		if (ejecutor == this.propietario){
			throw new AvisoException(message: "No puede aprobar su propio aviso")
		}

		this.state = AvisoState.APROBADO
	}


	/* postular */
	public postular(Usuario ejecutor){
		
		if (this.propietario != ejecutor){
			throw new AvisoException(message: "Solo el dueño del aviso puede pedir aprobacion")
		}
		
		println this.state
		if (this.state != AvisoState.BORRADOR) { 
			throw new AvisoException(message : "El aviso no está en BORRADOR")
		}
		
		this.state = AvisoState.POSTULADO
	}


	/* recibirOferta */
	public recibirOferta(Oferta oferta, Usuario ofertante){
	
		if (this.state != AvisoState.APROBADO){
			throw new OfertaException(message : "El aviso no está aprobado")
		}

		if (this.propietario == ofertante){
			throw new OfertaStateFlowException(message: "No puede ofertar su propio aviso")
		}
		
		// state.validateStateAccess(this, ejecutor);
		// state.validateStateFlow(this);
		// this.state = state
	}


	/* toString */
	String toString(){
		this.id + "| owner:" + this.lote.usuario + "| consignatario: " +  this.consignatario + " | " + this.state 
	}


}
