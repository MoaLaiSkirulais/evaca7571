package evaca

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/**
 * LoteReader 
 */	
class LoteReader {

	
	/**
	 * loadFromCsv 
	 */
	public loadFromCsv(String path){

		File csvFile = new File(LocalSystem.getDataResource("/mock/csv/lotes.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->
			
			def lote = new Lote()

			// def lote1 = new Lote(usuario:administrador)
			def administrador = Usuario.findByUsername("administrador")
			
			/* propietario */
			println fields[0].trim()
			def propietario = Usuario.findByUsername(fields[0].trim())
			lote.propietario = propietario
			
			/* raza */
			def raza = Raza.findByNombre(fields[1].trim())
			if (!raza) {
				raza = new Raza(usuario:administrador) 
				raza.nombre = fields[1].trim()
				raza.save(flush:true, failOnError: true)
			}
			
			lote.raza = raza
			
			/* categoria */
			def categoria = Categoria.findByNombre(fields[2].trim())
			if (!categoria) {
				categoria = new Categoria(usuario:administrador) 
				categoria.nombre = fields[2].trim()
				categoria.save(flush:true, failOnError: true)
			}
			
			lote.categoria = categoria
			
			/* aviso */
			/* voy a hacer el flujo normal, no voy a ir directo aunque pudiera con los states */
			lote.iniciar()
			lote.aviso.precio = Float.parseFloat(fields[4].trim())
			lote.aviso.plazo = Plazo.findByNombre(fields[5].trim())
			
			/* consignatario */
			def consignatario = Usuario.findByUsername(fields[6].trim())
			lote.aviso.consignatario = consignatario
			
			def state = fields[3].trim()
			switch (state) { 
			
				case ~/^POSTULADO$/:
					lote.aviso.postular(lote.propietario);
					break
					
				
				case ~/^APROBADO$/:
					lote.aviso.postular(lote.propietario);
					lote.aviso.aprobar(administrador);
					break
				
				// case ~/^RECHAZADO$/:
					// lote.aviso.rechazar();
					// break
				
				// case ~/^CANCELADO$/:
					// lote.aviso.cancelar();
					// break
				
				// case ~/^BORRADOR$/:				
					// break

			}   

			lote.aviso.state = fields[3].trim()
			
			/* save */
			lote.save(flush:true, failOnError: true)

			i++
			def path1 = "/mock/lotes/1 (" + i + ").jpg"
			println path1

			def r = new ImageReader()
			try {
				lote.image = r.readImageFile(LocalSystem.getDataResource(path1))
				lote.save(flush:true, failOnError: false)
			} catch (e) {}
		

		}
	
	}
}
