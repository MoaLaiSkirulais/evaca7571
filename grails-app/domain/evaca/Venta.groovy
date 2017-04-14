package evaca

class Venta {
	
	Date fechaCreacion
	
	Oferta oferta
	static belongsTo = [oferta:Oferta] 

    static constraints = {
    }
}
