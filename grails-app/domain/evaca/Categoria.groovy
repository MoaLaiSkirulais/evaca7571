package evaca

class Categoria {

	Date fechaCreacion	
	String nombre
	Usuario usuario

	static hasMany = [lotes:Lote]

	Set lotes
	static constraints = {
		nombre(nullable:false, blank:false)
		fechaCreacion blank: true, nullable: true
	}
	
	public Categoria() {
		this.fechaCreacion = new Date();
	}

	def beforeValidate() {
		// this.fechaCreacion = new Date()
		// this.usuario = Usuario.list()[2]
    }

	String toString(){
		this.nombre
	}

}

