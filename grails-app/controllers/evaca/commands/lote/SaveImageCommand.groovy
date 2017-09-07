package evaca.lote

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile


/* SaveImageCommand */
class SaveImageCommand implements Validateable {
    
	Integer loteId
	MultipartFile image

    static constraints = {       
    }
}