package evaca

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/**
 * OfertaReader 
 */	
class OfertaReader {

	
	/**
	 * loadFromCsv 
	 */
	public loadFromCsv(String path){

		File csvFile = new File(LocalSystem.getDataResource("/mock/csv/ofertas.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->
		
		
			println fields[0].trim()
			println fields[1].trim()
			println fields[2].trim()
			println fields[3].trim()
			println fields[4].trim()
			
			
			def ofertante = Usuario.findByUsername(fields[0].trim())
			
			
			Aviso.list().each {
			
				println "Aviso ${it}"
			
				def oferta = new Oferta(propietario:ofertante)
				oferta.plazo = Plazo.findByNombre(fields[4].trim())
				oferta.precio = Float.parseFloat(fields[3].trim())
				oferta.aviso = it
				try {
					oferta.postular(ofertante) /* aca es interesante pq el ofertante es el ismo que el propietario! puede volar ese param! */
					oferta.save(flush:true, failOnError: true)
				} catch (OfertaException e){}
				
			} 

			// def usuario = new Oferta(
				// username: fields[0].trim(), 
				// nombre: fields[0].trim(), 
				// apellido: fields[0].trim(), 
				// email: fields[1].trim(), 
				// comision: fields[3].trim()
			// )
			
			// /* profile */
			// def profile = fields[2].trim()
			// switch (profile) { 

				// case ~/^CONSIGNATARIO$/:
					// usuario.profile = UsuarioProfile.CONSIGNATARIO
					// break
				
				// case ~/^PRODUCTOR$/:
					// usuario.profile = UsuarioProfile.PRODUCTOR
					// break
					
				// case ~/^ADMINISTRADOR$/:
					// usuario.profile = UsuarioProfile.ADMINISTRADOR
					// break
			// }

			// usuario.password = ''
			// usuario.postular()

			// i++
			// def path1 = "/mock/usuarios/1-(" + i + ").jpg"
			// println path1
			
			// def r = new ImageReader()
			// usuario.image = r.readImageFile(LocalSystem.getDataResource(path1))
			// usuario.save(flush:true, failOnError: false)
		

		}
	
	}
}
