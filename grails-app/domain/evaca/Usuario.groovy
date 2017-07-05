package evaca

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='email')
class Usuario {

	Date fechaCreacion
	String nombre
	String apellido
	String email
	String username
	String tbTipo
	String password
	String tbState
	Float puntaje
	Float comision
	
	Date fechaActivacion
	Usuario usuarioActivacion

	static hasMany = [ofertas: Oferta, resenas: Resena, lotes: Lote]	


	/* constraints */
    static constraints = {
	
		fechaCreacion blank: true, nullable: true
		nombre()
		apellido()
		email nullable: true, email: true, unique: true
		tbState nullable: true, inList: ['Aprobacion', 'Activo', 'Inactivo']
		tbTipo inList: ['Consignatario', 'Productor', 'Administrador']		
		username size: 6..15, blank: false, unique: true
		password()
		puntaje blank: true, nullable: true, editable: false, defaultValue: 0
		comision()
		
		fechaActivacion nullable: true
		usuarioActivacion nullable: true
    }



	/* mapping */
    static mapping = {
        sort "fechaCreacion"

		usuarioActivacion lazy: false

    }



	/* Usuario */
    public Usuario() {
		this.fechaCreacion = new Date();
		this.tbState = "Aprobacion";
		this.tbTipo = "Productor";		
    }



	/* setFechaCreacion */
    void setFechaCreacion(Date f) {
		println "this.fechaCreacion" + this.fechaCreacion
    }


	
	/* setFechaActivacion */
    // void setFechaActivacion(Date f) {}
	

	
	/* setUsuarioActivacion */
    // void setUsuarioActivacion(Usuario u) {}



	/* setTbState() */
	// public void setTbState(String tbState){
	// }

	 

	/* setTbState() */
	public void setTbTipo(String tbTipo){
		if (tbTipo == 'Administrador') {
			// throw new DomainException(message:"No se puede promover a administrador")
		}
		this.tbTipo=tbTipo
	}


	/* activar */	
	public void activar(Usuario ejecutor){
	
		if (ejecutor?.tbTipo != 'Administrador') {
			throw new DomainException(message:"You must be Admin to perform this action")
		}

		if (this.tbState != 'Aprobacion' && this.tbState != 'Inactivo'){
			throw new DomainException(message : "El usuario no está Aprobacion")				
		}
		
		this.fechaActivacion = new Date()
		this.usuarioActivacion = ejecutor
		this.tbState = 'Activo'
		// return this
	}


	/* inactivar */	
	public void inactivar(Usuario ejecutor){
	
		if (ejecutor?.tbTipo != 'Administrador') {
			throw new UserRegistrationException(message:"You must be Admin to perform this action")
		}
		
		if (this.tbState != 'Activo'){
			throw new DomainException(message : "El usuario no está Activo")
		}
		this.tbState = 'Inactivo'
	}


	/* joder */	
	public void joder(){
		println "usuario.joder"
		throw new DomainException(message : "No quiero joder")
	}

	
	/* toString */	
	String toString(){
		this.nombre + " " + this.apellido
	}

}
