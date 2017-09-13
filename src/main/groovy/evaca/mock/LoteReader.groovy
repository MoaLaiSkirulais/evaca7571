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
		def i = 1
		csvFile.splitEachLine(',') { fields ->
		
			def propietario = Usuario.findByUsername(fields[0].trim())
			
			def administrador = Usuario.findByUsername("administrador")
			
			/* selecciona propietario */			
			// lote.propietario = propietario /* analizar esto! */
			
			def lote = new Lote()

			/* selecciona raza */
			def raza = Raza.findByNombre(fields[1].trim())
			if (!raza) {
				raza = new Raza(usuario:administrador) 
				raza.nombre = fields[1].trim()
				raza.save(flush:true, failOnError: true)
			}
			
			lote.raza = raza
			
			/* selecciona categoria */
			def categoria = Categoria.findByNombre(fields[2].trim())
			if (!categoria) {
				categoria = new Categoria(usuario:administrador) 
				categoria.nombre = fields[2].trim()
				categoria.save(flush:true, failOnError: true)
			}
			
			lote.categoria = categoria
			
			/* imagen asociada */
			def r = new ImageReader()
			def path1 = "/mock/lotes/1 (" + i + ").jpg"
			try {
				lote.image = r.readImageFile(LocalSystem.getDataResource(path1))
			} catch (e) {}
			
			/* intenta postular */
			try {
				propietario.postularLote(lote)
			} catch (Exception e){
				println "error: " + e
				return /* es como el continue */
			}

			/* tratamiento del aviso dado que se postuló el lote sin errores */
			def consignatario = Usuario.findByUsername(fields[6].trim())
			lote.aviso.precio = Float.parseFloat(fields[4].trim())
			lote.aviso.plazo = Plazo.findByNombre(fields[5].trim())
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
		
			}   

			lote.aviso.state = fields[3].trim()
			
			/* guarda cambios en el AR */
			try {
				propietario.save(flush:true, failOnError: true)
			} catch (Exception e){}
			
		
			i++
		}
	
	}
}
