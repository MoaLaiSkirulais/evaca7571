package evaca

class Pregunta {
	
	Usuario propietario
	Date fechaCreacion
	String label
	
	// static hasMany = [resenaPreguntas: ResenaPregunta]

	/* constraints */
	static constraints = {
		label(nullable:false, blank:false, unique: true)
		// fechaCreacion blank: true, nullable: true
	}
	
	
	/* Pregunta */
	public Pregunta() {
		this.fechaCreacion = new Date();
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
