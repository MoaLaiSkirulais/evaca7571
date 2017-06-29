package evaca

class Plazo {

	Date fechaCreacion	
	String nombre
	Usuario usuario
	
	static hasMany = [ofertas:Oferta]
	Set ofertas

	static constraints = {
		nombre(nullable:false, blank:false, unique: true)
		fechaCreacion blank: true, nullable: true
	}
	
	public Plazo() {
		this.fechaCreacion = new Date();
	}
	
	String toString(){
		this.nombre
	}

}

