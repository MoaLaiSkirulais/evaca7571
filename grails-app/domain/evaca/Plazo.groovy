package evaca

class Plazo {

	Date fechaCreacion	
	String nombre
	Usuario propietario
	
	static hasMany = [ofertas:Oferta]
	Set ofertas

	
	/* constraints */
	static constraints = {
		nombre(nullable:false, blank:false, unique: true)
		fechaCreacion blank: true, nullable: true
	}
	
	
	/* Plazo */
	public Plazo() {
		this.fechaCreacion = new Date();
	}
	
	
	/* toString */
	String toString(){
		this.nombre
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

}

