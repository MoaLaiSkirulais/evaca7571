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
		email email: true, unique: true
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
	

	
	/* toString */	
	String toString(){
		this.nombre + " " + this.apellido
	}

}
