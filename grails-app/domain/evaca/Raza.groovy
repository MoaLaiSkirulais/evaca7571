package evaca

class Raza {

	Date fechaCreacion	
	String nombre
	Usuario usuario
	
	static hasMany = [lotes:Lote]
	Set lotes

	
	/* constraints */
	static constraints = {
		nombre(nullable:false, blank:false, unique: true)
		fechaCreacion blank: true, nullable: true
	}

	
	/* Raza */
	public Raza() {
		this.fechaCreacion = new Date();
	}

	
	/* setFechaCreacion */
	public setFechaCreacion(Date date) {
		println "setFechaCreacion!!"
		// println this.tbState		
		// tbState = tbState
	}

	
	/* toString */
	String toString(){
		this.nombre
	}

}

