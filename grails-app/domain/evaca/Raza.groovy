package evaca

class Raza {

	Date fechaCreacion	
	String nombre
	Usuario usuario
	
	static hasMany = [lotes:Lote]
	Set lotes

	static constraints = {
		nombre(nullable:false, blank:false, unique: true)
		fechaCreacion blank: true, nullable: true
	}
	
	public Raza() {
		this.fechaCreacion = new Date();
	}
	
	def beforeInsert() {
		this.fechaCreacion = new Date()
	}
	
	def beforeValidate() {
    }

	String toString(){
		this.nombre
	}

}

