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
	
        if (usuario == null) {
			render "no-img"
            return
        }
		
		if (usuario.image == null) {
			println "pijaaaaaaaaaaaaaaaaaaaaassssssssssssssssssssss"
			final Resource image = grailsResourceLocator.findResourceForURI('/sham/img/users/anon.png')
			render (file: image.inputStream, contentType: '')
            return
        }

		render (file: usuario.image, contentType: '')
		return
    }
	
	
	/* save_image */ /* podria pasar a un service! */
	// def save_image(SaveImageCommand cmd) {	
	@Action
	def save_image() {	
	
		// render cmd.dump()
		// render params
		// return
	
		def usuario = new Usuario().get(params.usuario.id)
		if (!usuario){
			throw new LoteNotFoundException();
		}
 	
		usuario.image = params.image.bytes 
		usuario.save(flush:true, failOnError: true)

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"show_profile", id:usuario.id
    }

 


}
