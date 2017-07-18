package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	Plazo plazo
	Float precio
	OfertaState tbState
	Venta venta 

	static belongsTo = [aviso:Aviso, usuario:Usuario, plazo:Plazo]	
	
	
	/* Oferta() */
	public Oferta() {
		this.fechaCreacion = new Date();
		this.tbState = OfertaState.BORRADOR;
	}	
	
	
	/* constraints */
    static constraints = {
		venta nullable: true
    }
	
	
	/* changeState */
	public changeState(OfertaState tbState, Usuario ejecutor){
	
		println "setTbState: " + tbState
		println "this.setTbState: " + this.tbState

		tbState.validateStateAccess(this, ejecutor);
		this.tbState = tbState.validateStateFlow(this);

	}

	/* setTbState() */
	// public void setTbState(String tbState){


		// if (tbState == 'Aceptada'){
			// if (this.tbState != 'Vigente'){
				// throw new DomainException(message : "La oferta no está Vigente")
			// }
			// this.aviso.tbState = 'Vendido'

			// /* genero la venta */
			// this.venta = new Venta(
				// oferta: this, 
				// fechaCreacion: new Date()
			// )
		// }

		
	// }
	
	
}