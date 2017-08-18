package evaca

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile


/* AvatarImageCommand */
class AvatarImageCommand implements Validateable {
    
	MultipartFile avatarImageFile

    static constraints = {
        
        avatarImageFile  validator: { val, obj ->
            
			if (val == null) {
				return false
            }
			
            if (val.empty) {
                return false
            }

            ['jpeg', 'jpg', 'png'].any { extension -> 
                 val.originalFilename?.toLowerCase()?.endsWith(extension)
            }
        }
    }
}