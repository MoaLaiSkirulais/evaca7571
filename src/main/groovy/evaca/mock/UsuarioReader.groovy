package evaca

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/**
 * UsuarioReader 
 */	
class UsuarioReader {

	
	/**
	 * loadFromCsv 
	 */
	public loadFromCsv(String path){

		File csvFile = new File(LocalSystem.getDataResource("/mock/usuarios/usuarios.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->
		

			def usuario = new Usuario(
				username: fields[0].trim(), 
				nombre: fields[0].trim(), 
				apellido: fields[0].trim(), 
				email: fields[1].trim(), 
				profile: UsuarioProfile.CONSIGNATARIO, 
				comision: 11
			)

			usuario.password = ''
			usuario.postular()

			i++
			def path1 = "/mock/usuarios/images/1-(" + i + ").jpg"
			println path1
			
			def r = new ImageReader()
			usuario.image = r.readImageFile(LocalSystem.getDataResource(path1))
			usuario.save(flush:true, failOnError: false)
		

		}
	
	}
}
