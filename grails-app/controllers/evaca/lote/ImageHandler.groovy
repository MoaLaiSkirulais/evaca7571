package evaca

// // import org.springframework.core.io.Resource
// import org.codehaus.groovy.grails.core.io.ResourceLocator
// import org.springframework.core.io.Resource
// import org.springframework.core.io.ResourceLocator
// import org.codehaus.groovy.grails.core.io
import org.springframework.core.io.Resource

import grails.web.Action
import org.springframework.beans.factory.annotation.Autowired;

trait ImageHandler {

	// @Autowired
	// ResourceLocatorService grailsResourceLocator
	// def grailsResourceLocator
	
	/* get_image */
	// @Autowired
	@Action
	def _get_image(Lote lote) { 
	 
		// @Autowired
		// def grailsResourceLocator
 
        if (lote == null) {
			render "no-img"
            return
        }
		
		println "----"
		println grailsResourceLocator
		println "----"
		
		if (lote.image == null) {
			final Resource image = grailsResourceLocator.findResourceForURI('/sham/img/users/anon.png')
			render (file: image.inputStream, contentType: '')
            return
        }
		
		render (file: lote.image)
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
