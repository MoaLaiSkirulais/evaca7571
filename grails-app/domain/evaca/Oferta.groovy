package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	Plazo plazo
	Float precio
	OfertaState state
	Venta venta 

	static belongsTo = [aviso:Aviso, usuario:Usuario, plazo:Plazo]	
	
	
	/* Oferta() */
	public Oferta() {
		this.fechaCreacion = new Date();
		this.state = OfertaState.BORRADOR;
	}	
	
	
	/* constraints */
    static constraints = {
		venta nullable: true
    }
	
	
	/* changeState */
	public changeState(OfertaState state, Usuario ejecutor){
	
		println "setTbState: " + state
		println "this.setTbState: " + this.state

		state.validateStateAccess(this, ejecutor);
		this.state = state.validateStateFlow(this);

	}

	
}