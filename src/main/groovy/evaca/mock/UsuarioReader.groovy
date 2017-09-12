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

		File csvFile = new File(LocalSystem.getDataResource("/mock/csv/usuarios.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->

			def usuario = new Usuario(
				username: fields[0].trim(), 
				nombre: fields[0].trim(), 
				apellido: fields[0].trim(), 
				email: fields[1].trim(), 
				comision: fields[3].trim()
			)
			
			/* profile */
			def profile = fields[2].trim()
			switch (profile) { 

				case ~/^CONSIGNATARIO$/:
					usuario.profile = UsuarioProfile.CONSIGNATARIO
					break
				
				case ~/^PRODUCTOR$/:
					usuario.profile = UsuarioProfile.PRODUCTOR
					break
					
				case ~/^ADMINISTRADOR$/:
					usuario.profile = UsuarioProfile.ADMINISTRADOR
					break
			}

			usuario.password = ''
			usuario.postular()

			i++
			def path1 = "/mock/usuarios/1-(" + i + ").jpg"
			
			def r = new ImageReader()
			usuario.image = r.readImageFile(LocalSystem.getDataResource(path1))
			usuario.save(flush:true, failOnError: false)
		

		}
	
	}
}
