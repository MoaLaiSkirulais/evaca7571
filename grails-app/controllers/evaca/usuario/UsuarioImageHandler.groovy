package evaca

import org.grails.core.io.ResourceLocator
import org.springframework.core.io.Resource

import grails.web.Action
import org.springframework.beans.factory.annotation.Autowired;

trait UsuarioImageHandler {

	@Resource("grailsResourceLocator")
	ResourceLocator grailsResourceLocator

	
	/* get_image */ 
	@Action
	def get_image(Usuario usuario) { 
	
		println  "------------>"
 
        if (usuario == null) {
			println  "------------>"
			render "no-img"
            return
        }
		
		println grailsResourceLocator
		println  "------------>"
		
		if (usuario.image == null) {
			final Resource image = grailsResourceLocator.findResourceForURI('/sham/img/users/anon.png')
			render (file: image.inputStream, contentType: '')
            return
        }
		
		println  "------------>"
		println  usuario.image
		println  "------------>"

		render (file: usuario.image, contentType: '')
		return
    }
	
	
	/* save_image */ /* podria pasar a un service! */
	@Action
	def save_image(SaveImageCommand cmd) {	
	
		def usuario = new Usuario().get(cmd.loteId)
		if (!usuario){
			throw new LoteNotFoundException();
		}
 	
		usuario.image = cmd.image.bytes 
		usuario.save(flush:true, failOnError: false)

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:usuario.id
    }

 


}
