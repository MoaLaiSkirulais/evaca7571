package evaca

class Venta {
	
	Date fechaCreacion
	// Oferta oferta
	Aviso aviso
	
	static belongsTo = [
		aviso:Aviso
	] 

    static constraints = {
		fechaCreacion nullable: true
		// oferta nullable: true
    }
	
	
	/* Venta() */
	public Venta() {
		this.fechaCreacion = new Date();
	}	
	
	// String toString(){
		// // this.id + " | " + this.fechaCreacion + " | " + this.oferta.aviso.lote
	// }
}
