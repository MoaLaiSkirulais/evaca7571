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

	static hasMany = [ofertas: Oferta, resenas: Resena, lotes: Lote]


	/* constraints */
    static constraints = {
	
		fechaCreacion blank: false, nullable: false
		email nullable: false, email: true, unique: true
		password nullable: true, blank: true
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
		this.profile = UsuarioProfile.PRODUCTOR
		this.state = UsuarioState.BORRADOR
		this.password = ""
		this.avatar = "/static/sham/img/users/5.jpg"
    }
	
	
	/* changeState */
	public changeState(UsuarioState state, Usuario ejecutor){

		state.validateStateAccess(this, ejecutor);
		state.validateStateFlow(this);
		this.state = state

	}

	
	/* toString */	
	String toString(){
		this.username
	}

}
