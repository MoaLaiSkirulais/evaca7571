package evaca

import grails.validation.Validateable


/* SaveProfileCommand */
class SaveProfileCommand implements Validateable {
    
	Integer usuarioId
	String nombre
	String apellido
	Float comision

}