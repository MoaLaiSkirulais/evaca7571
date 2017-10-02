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
	
		println "Loading usuarios from csv..."

		File csvFile = new File(LocalSystem.getDataResource("/mock/csv/usuarios.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->

			def usuario = new Usuario()
			usuario.username = fields[0].trim()
			usuario.nombre = fields[0].trim()
			usuario.apellido = fields[0].trim()
			usuario.email = fields[1].trim()
			usuario.comision = fields[3].trim()
			
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
			
			/* profile */
			def administrador = Usuario.findByUsername("administrador")
			def state = fields[4].trim()

			switch (state) { 

				case ~/^DESAPROBADO$/:
					usuario.desaprobar(administrador)
					break
				
				case ~/^APROBADO$/:
					usuario.aprobar(administrador)
					break
					
				case ~/^POSTULADO$/:					
					break
			}
			
			usuario.save(flush:true, failOnError: false)		

		}
	
	}
}
