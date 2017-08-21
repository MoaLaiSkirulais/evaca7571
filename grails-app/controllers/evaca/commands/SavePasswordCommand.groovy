package evaca

import grails.validation.Validateable


/* SavePasswordCommand */
class SavePasswordCommand implements Validateable {
    
	Integer usuarioId
	String currentPassword
	String password
	String rePassword 

    static constraints = {
 
        usuarioId nullable: false, blank: false
        currentPassword nullable: false, blank: false
        password size: 6..15, nullable: false, blank: false
        rePassword nullable: false, blank: false
    }
}