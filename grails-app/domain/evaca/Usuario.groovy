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

	static hasMany = [ofertas: Oferta, resenas: Resena, lotes: Lote]


	/* constraints */
    static constraints = {
	
		fechaCreacion blank: true, nullable: true
		email nullable: true, email: true, unique: true
		state nullable: false
		profile nullable: false
		username size: 6..15, blank: false, unique: true
		puntaje blank: true, nullable: true, editable: false, defaultValue: 0		
    }


	/* mapping */
    static mapping = {

        sort "fechaCreacion"
		usuarioActivacion lazy: false
    }


	/* Usuario */
    public Usuario() {

		this.fechaCreacion = new Date()
		this.state = UsuarioState.APROBACION
		this.profile = UsuarioProfile.PRODUCTOR
    }
	
	
	/* changeState */
	public changeState(UsuarioState state, Usuario ejecutor){

		state.validateStateAccess(this, ejecutor);
		this.state = state.validateStateFlow(this);

	}
	
	/* toString */	
	String toString(){
		this.nombre + " " + this.apellido
	}

}
