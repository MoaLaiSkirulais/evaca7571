package evaca

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile


/* SaveImageCommand */
class SaveImageCommand implements Validateable {
    
	Integer usuarioId
	MultipartFile image

    static constraints = {       
    }
}