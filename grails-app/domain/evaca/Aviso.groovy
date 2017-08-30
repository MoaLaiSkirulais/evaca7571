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
		state.validateStateAccess(this, ejecutor);
		state.validateStateFlow(this);
		this.state = state
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
