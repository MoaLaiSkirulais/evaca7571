package evaca

class Raza {

	Date fechaCreacion	
	String nombre
	Usuario usuario
	
	static hasMany = [lotes:Lote]
	Set lotes

	static constraints = {
		nombre(nullable:false, blank:false)
		fechaCreacion blank: true, nullable: true
	}
	
	def beforeInsert() {
		this.fechaCreacion = new Date()
		this.usuario = Usuario.list()[2]
	}
	
	def beforeValidate() {
		this.fechaCreacion = new Date()
		this.usuario = Usuario.list()[2]
    }

	String toString(){
		this.nombre
	}

}

