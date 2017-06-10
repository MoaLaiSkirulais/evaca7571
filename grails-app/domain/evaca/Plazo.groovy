package evaca

class Plazo {

	Date fechaCreacion	
	Usuario usuario
	String nombre
	
	// static hasMany = [oferta:Oferta]
	// Set ofertas

	static constraints = {
		nombre(nullable:false, blank:false, unique: true)
		fechaCreacion blank: true, nullable: true
	}
	
	public Plazo() {
		this.fechaCreacion = new Date();
	}
	
	def beforeInsert() {
		this.fechaCreacion = new Date()
	}
	
	String toString(){
		this.nombre
	}

}

