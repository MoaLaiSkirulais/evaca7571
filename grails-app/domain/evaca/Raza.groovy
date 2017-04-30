package evaca

class Raza {

	Date fechaCreacion	
	String name
	
	static hasMany = [lotes:Lote]
	Set lotes

	static constraints = {
		name(nullable:false, blank:false)
		fechaCreacion blank: true, nullable: true
	}

	String toString(){
		this.name
	}

}

