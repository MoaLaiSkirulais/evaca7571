package evaca

class Venta {
	
	Date fechaCreacion
	Oferta oferta
	
	// Oferta oferta
	static belongsTo = [oferta:Oferta] 

    static constraints = {
		oferta nullable: false
    }
	
	// String toString(){
		// // this.id + " | " + this.fechaCreacion + " | " + this.oferta.aviso.lote
	// }
}
