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

		}
		
		/* aprobar 16 ofertas */
		/* aprobar 16 aviso? */
		i = 0
		Oferta.list().each {
			
			println "Oferta ${it}"
			
			if (i == 9) {return false }
			i++
				
		} 
	
	}
}
