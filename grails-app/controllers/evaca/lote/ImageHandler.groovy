package evaca

import org.grails.core.io.ResourceLocator
import org.springframework.core.io.Resource

import grails.web.Action
import org.springframework.beans.factory.annotation.Autowired;

trait ImageHandler {

	@Resource("grailsResourceLocator")
	ResourceLocator grailsResourceLocator

	
	/* get_image */ 
	@Action
	def get_image(Lote lote) { 
	
		// render lote
		// return
	
        if (lote == null) {
			render "no-img"
            return
        }
		
		if (lote.image == null) {
			final Resource image = grailsResourceLocator.findResourceForURI('/sham/img/lotes/anylote.png')
			render (file: image.inputStream, contentType: '')
            return
        }
		
		render (file: lote.image, contentType: '')
		return
    }
	
	
	/* save_image */ 
	@Action
	def save_image(SaveImageCommand cmd) {	
	
		def lote = new Lote().get(cmd.loteId)
		if (!lote){
			throw new LoteNotFoundException();
		}
 	
		lote.image = cmd.image.bytes 
		lote.save(flush:true, failOnError: false)
	
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:lote.id
    }

 


}
