package evaca

class Categoria {

	Date fechaCreacion	
	String nombre
	Usuario usuario
	Set lotes

	static hasMany = [lotes:Lote]

	
	/* constraints */
	static constraints = {
		nombre(nullable:false, blank:false)
		fechaCreacion blank: true, nullable: true
	}
	
	
	/* Categoria */
	public Categoria() {
		this.fechaCreacion = new Date();
	}

	
	/* toString */
	String toString(){
		this.nombre
	}

}

