package evaca

import grails.validation.Validateable

/* PostularCommand */
class PostularCommand implements Validateable {
    
	String nombre
	String apellido
	String email
	String username
	UsuarioProfile profile
	String password
	String repassword
	Float comision
	
    static constraints = {
	
		email nullable: false, blank: false, email: true, unique: true
		username nullable: false, blank: false, unique: true
		nombre nullable: false, blank: false
		apellido nullable: false, blank: false		
		profile nullable: false, blank: false
		password nullable: false, blank: false
		repassword nullable: false, blank: false
		comision nullable: false, blank: false

    }
}