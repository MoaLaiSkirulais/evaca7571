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
		// this.fechaCreacion = new Date()
	}
	
	def beforeValidate() {
    }
	
	/* setFechaCreacion() */
	public setFechaCreacion(Date date) {
		println "setFechaCreacion!!"
		// println this.tbState		
		// tbState = tbState
	}

	String toString(){
		this.nombre
	}

}

