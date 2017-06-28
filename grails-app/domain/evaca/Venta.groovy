package evaca

class Venta {
	
	Date fechaCreacion
	
	// Oferta oferta
	static belongsTo = [oferta:Oferta] 

    // static constraints = {
		// oferta nullable: true
    // }
	
	String toString(){
		// this.id + " | " + this.fechaCreacion + " | " + this.oferta.aviso.lote
	}
}
