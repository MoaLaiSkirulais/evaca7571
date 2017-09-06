package evaca

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/* UsuarioReader */	
class UsuarioReader {
	
	/* loadFromCsv */	
	public loadFromCsv(String path){

		File csvFile = new File(LocalSystem.getDataResource("/mock/usuarios/usuarios.csv"));
		csvFile.splitEachLine(',') { fields ->

			def usuario = new Usuario(
				username: fields[0].trim(), 
				nombre: fields[0].trim(), 
				apellido: fields[0].trim(), 
				email: fields[2].trim(), 
				profile: UsuarioProfile.CONSIGNATARIO, 
				comision: 11
			)

			usuario.password = ''
			usuario.postular()

			def r = new ImageReader()
			usuario.avatarImageBytes = r.readImageFile(LocalSystem.getDataResource("/mock/usuarios/images/1.jpg"))

			usuario.save(flush:true, failOnError: false)
		

		}
	
	}
}
