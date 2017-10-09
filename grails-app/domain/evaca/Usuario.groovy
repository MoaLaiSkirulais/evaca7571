package evaca

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='email')
class Usuario {

	Date fechaCreacion
	String nombre
	String apellido
	String email
	String username
	UsuarioProfile profile
	String password
	UsuarioState state
	Float puntaje
	Float comision
	String avatar
	
	byte[] image 
    String avatarImageContentType 

	static hasMany = [resenas: Resena, lotes: Lote, ofertas: Oferta]


	/* constraints */
    static constraints = {
	
		/* not null */
		fechaCreacion blank: false, nullable: false
		email nullable: false, email: true, unique: true
		password size: 6..15, nullable: true, blank: true
		state nullable: false
		profile nullable: false
		username size: 6..15, blank: false, unique: true
		
		/* nullables */
		puntaje blank: true, nullable: true, editable: false, defaultValue: 0		
		image nullable: true
        avatarImageContentType nullable: true
    }


	/* mapping */
    static mapping = {

        sort "fechaCreacion"
		// usuarioActivacion lazy: false
		image column: 'image', sqlType: 'longblob' 
    }


	/* Usuario */
    public Usuario() {

		this.fechaCreacion = new Date()
		this.profile = UsuarioProfile.PRODUCTOR
		this.state = UsuarioState.BORRADOR
		this.password = ""
		this.avatar = "/static/sham/img/users/5.jpg"
    }
	

	/* toString */	
	String toString(){
		this.username
	}
	
	
	/* postular */
	public postular(){

		/* borrador? */
		if (this.state != UsuarioState.BORRADOR) { 
			throw new UsuarioStateFlowException(message : "El usuario no está en BORRADOR")
		}
		
		/* constrains? */
		this.validate()
		if (this.hasErrors()) {
		
			this.errors.allErrors.each { 
				def msg = ErrorHandler.build(it.defaultMessage, it.field)
				throw new UsuarioException(message : msg)				
			}
		}

		this.puntaje = 0
		this.state = UsuarioState.POSTULADO	
	}

	
	/* aprobar */
	public aprobar(Usuario ejecutor){

		if (this.state == UsuarioState.APROBADO) { 
			throw new UsuarioStateFlowException(message : "El usuario ya está aprobado")
		}
		
		/* está aprobacion? */
		if (this.state != UsuarioState.POSTULADO){
			throw new UsuarioStateFlowException(message : "El usuario no está postulado")
		}
		
		if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new UsuarioStateFlowException(message: "Se necesita un administrador para ejecutar esta accion")
		}
		
		this.state = UsuarioState.APROBADO	
	}
	
	
	/* desaprobar */
	public desaprobar(Usuario ejecutor){
		
		/* ya esta? */
		if (this.state == UsuarioState.DESAPROBADO){
			throw new UsuarioException(message : "El usuario ya está desaprobado")
		}
		
		/* admin? */
		if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new UsuarioException(message: "Se necesita un administrador para ejecutar esta accion")
		}
		
		this.state = UsuarioState.DESAPROBADO	
	}
	
	
	/* changePassword */
	public changePassword(String currentPassword, String newPassword, String newRepassword){
	
		/* solo estado aprobado puede agregar ofertas */
		if (this.state != UsuarioState.APROBADO){
			throw new UsuarioException(message : "El usuario no está aprobado")
		}

		/* check currentPassword */
		if (this.password != currentPassword){
			throw new UsuarioException(message : "Password actual incorrecto")
		}
		
		/* check passs repass */
		if (newPassword != newRepassword){
			throw new UsuarioException(message : "No coinciden los passwords")
		}
		
		this.password = newPassword

	}

	
	/* saveProfile */
	public saveProfile(){
	
		/* solo estado aprobado puede agregar ofertas */
		if (this.state != UsuarioState.APROBADO){
			throw new UsuarioException(message : "El usuario no está aprobado")
		}
		
		/* constrains? */
		this.validate()
		if (this.hasErrors()) {
		
			this.errors.allErrors.each { 
				def msg = ErrorHandler.build(it.defaultMessage, it.field)
				throw new UsuarioException(message : msg)				
			}
		}

	}
	
	
	/**
	 * lotes
	 */
	 
	/* postularLote */
	public postularLote(Lote lote){
		
		/* solo estado aprobado puede agregar ofertas */
		if (this.state != UsuarioState.APROBADO){
			throw new UsuarioException(message : "El usuario no está aprobado")
		}

		/* delega bl propia de oferta */
		lote.propietario = this
		lote.postular() 

		/* agregar a lotes */
		this.addToLotes(lote)

	}

}
