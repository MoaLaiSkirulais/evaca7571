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
	
	Boolean tbStateValid
	String valid_tbState

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
		
		valid_tbState nullable: true
		
        tbState validator: { val, obj ->
			return true
			if (val == 'Aprobacion') {
				return "Todo mal"
			}
        }

		tbStateValid validator: { val, obj ->
			println "val2: " + val
			return val
        }

		valid_tbState validator: { val, obj ->
			println "valid_tbState: " + val
			return val
        }


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
		this.tbStateValid = true;
		this.valid_tbState = null;
		
    }
	


	/* setTbState() */
	public void setTbState(String tbState){
	
		// this.tbStateValid = true
		this.valid_tbState = null
	

		if (this.tbState == tbState){
			println "mismo"
			return
		}

		if (tbState == 'Aprobacion'){
			if (this.tbState == 'Activo' || this.tbState == 'Inactivo'){
				// throw new DomainException(message : "El usuario ya fue Aprobado")
				println "El usuario ya fue Aprobado"
				this.valid_tbState = "El usuario ya fue Aprobado"
				// this.tbStateValid = false
				// return false
			}

			// this.errors.rejectValue('tbState', 'Aprobacion')				
		}

		if (tbState == 'Activo'){
			if (this.tbState != 'Aprobacion'){
				// throw new DomainException(message : "El usuario no está Aprobacion")
				println "El usuario no está Aprobacion"
				this.valid_tbState = "El usuario no está Aprobacion"
				// this.tbStateValid = false
				// return false
			}
		}

		if (tbState == 'Inactivo'){
			if (this.tbState != 'Activo'){
				// throw new DomainException(message : "El usuario no está Activo")
				println "El usuario no está Activo"
				this.valid_tbState = "El usuario no está Activo"
				// this.tbStateValid = false
				// return false
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
