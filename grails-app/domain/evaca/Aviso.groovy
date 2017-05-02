package evaca

/* 
 * Aviso
 */

class Aviso {

	Date fechaCreacion
	Date fechaPublicacion
	Float precio
	String tbState
	Usuario consignatario
	Lote lote     
	
	static belongsTo = [lote:Lote, consignatario:Usuario]	
	static hasMany = [ofertas: Oferta]
	static constraints = {

		fechaCreacion nullable: true
		fechaPublicacion nullable: true
		tbState nullable: true, inList: ['Borrador', 'Publicado', 'Finalizado', 'Vendido','Aprobacion']

	}
	
	/* 
	 * beforeInsert() 
	 */

	def beforeInsert() {
		this.fechaCreacion = new Date()
		this.tbState = "Borrador"
	}
	
	/* 
	 * Aviso() 
	 */

	public Aviso() {
		this.fechaCreacion = new Date();
		this.tbState = "Borrador";
	}
	
	// String toString(){
		// this.tbState + this.precio + this.consignatario
	// }
	
    // public void setTbState(String tbState) {
		// if (tbState == 'Active'){
			// this.tbState = 'Finished'
		// } else {
			// this.tbState = tbState
		// }
    // }

}
