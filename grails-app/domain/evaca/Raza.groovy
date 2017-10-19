package evaca

class Raza {

	Date fechaCreacion	
	String nombre
	Usuario propietario
	
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
	}

	
	/* postular */
	public postular(){

		/* constrains? */
		this.validate()
		if (this.hasErrors()) {
		
			this.errors.allErrors.each { 
				def msg = ErrorHandler.build(it.defaultMessage, it.field)
				throw new DomainException(message : msg)				
			}
		}
		
		/* admin? */
		if (this.propietario?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new DomainException(message: "Se necesita un administrador para ejecutar esta accion")
		}

	}

	
	/* toString */
	String toString(){
		this.nombre
	}

}

