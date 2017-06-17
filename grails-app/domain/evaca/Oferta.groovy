package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	Plazo plazo
	Float precio
	String tbState

	static belongsTo = [aviso:Aviso, usuario:Usuario, plazo:Plazo]
	
	/* Oferta() */
	public Oferta() {
		this.fechaCreacion = new Date();
		this.tbState = 'Activa';
	}

	/* constraints */
    static constraints = {
		tbState nullable: true, inList: ['Activa', 'Rechazada', 'Aceptada', 'Cancelada']
    }

	// /* setTbState() */
	// public setTbState(String tbState) {
		// println "tbState!!"
		// println this.tbState		
		// tbState = tbState
	// }
	
	/* setPrecio() */
	// public setPrecio(Float p) {
		// println "precio!!"
		// this.precio = p
		// println this.precio
	// }

	// /* getPrecio() */
	// public getPrecio() {
		// return this.precio
	// }

	
}