package evaca


/* Aviso */	
class Aviso {

	Date fechaCreacion	
	Float precio
	AvisoState state
	Usuario propietario
	Usuario consignatario
	Lote lote     

	static belongsTo = [lote:Lote, consignatario:Usuario]	
	static hasMany = [ofertas: Oferta]

	
	/* constraints */
	static constraints = {

		state nullable: false
		consignatario nullable: false
		lote nullable: false
		precio nullable: false

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
		state.validateStateFlow(this);
	}


	/* toString */
	String toString(){
		this.id + "| owner:" + this.lote.usuario + "| consignatario: " +  this.consignatario + " | " + this.state 
	}


}
