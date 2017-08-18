package evaca

import grails.validation.Validateable


/* SetPasswordCommand */
class SetPasswordCommand implements Validateable {
    
	String currentPassword
	String newPassword
	String newRePassword 

    static constraints = {

        currentPassword nullable: false, blank: false
        newPassword nullable: false, blank: false
        password nullable: false, blank: false
    }
}