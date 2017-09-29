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
	def save_image() {	
	
		def lote = new Lote().get(params.lote.id)
		if (!lote){
			throw new LoteNotFoundException();
		}
 	
		lote.image = params.image.bytes 
		lote.save(flush:true, failOnError: true)
	
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:lote.id
    }

 


}
