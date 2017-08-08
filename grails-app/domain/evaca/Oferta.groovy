package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario propietario
	Plazo plazo
	Float precio
	OfertaState state
	Venta venta 

	static belongsTo = [aviso:Aviso, propietario:Usuario, plazo:Plazo]	
	static hasOne = [venta: Venta]
    // static mappedBy = [child: 'parent']
	// static mappedBy = [venta: "oferta"]


	
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
		state.validateStateAccess(this, ejecutor)
		state.validateStateFlow(this)
		this.state = state

	}

	
}