package evaca

import groovy.transform.EqualsAndHashCode

// @EqualsAndHashCode(includes='email')
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

    }


	
	/* mapping */
    static mapping = {
        sort "fechaCreacion"
    }


	
	/* Usuario */
    public Usuario() {
		this.fechaCreacion = new Date();
		this.tbState = "Aprobacion";
		this.tbTipo = "Productor";
    }
	


	/* setTbState() */
	public void setTbState(String tbState){
	
		println "this.tbState-" + this.tbState
		println "tbState-" + tbState
		// println "primero"
		if (this.tbState == tbState){
			println "mismo"
			return
		}

		if (tbState == 'Aprobacion'){
			if (this.tbState != 'Aprobacion'){
				throw new DomainException(message : "El usuario ya fue Aprobado")
			}
		}

		if (tbState == 'Activo'){
			// if (this.tbState != 'Aprobacion' && this.tbState != 'Activo'){
			if (this.tbState != 'Aprobacion'){
				println "pija"
				throw new DomainException(message : "El usuario no está Aprobacion")
			}
		}

		if (tbState == 'Inactivo'){
			if (this.tbState != 'Activo'){
				throw new DomainException(message : "El usuario no está Activo")
			}			
		}

		this.tbState = tbState
		
	}
	
	
	
	/* joder */	
	public void joder(){
		println "usuario.joder"
		throw new DomainException(message : "No quiero joder")
	}

	
	
	// /* toString */	
	// String toString(){
		// this.nombre + " " + this.apellido
	// }

}
