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
			
				// println "Aviso ${it}"
			
				def oferta = new Oferta(propietario:ofertante)
				oferta.plazo = Plazo.findByNombre(fields[4].trim())
				oferta.precio = Float.parseFloat(fields[3].trim())
				oferta.aviso = it
				try {
					it.addToOfertas(oferta)
					oferta.postular(ofertante) /* aca es interesante pq el ofertante es el ismo que el propietario! puede volar ese param! */
					// oferta.save(flush:true, failOnError: true)
					it.save(flush:true, failOnError: true)
				} catch (OfertaException e){}
				
			} 

		}

		/* aprobar 16 avisos, todas las ofertas */
		def administrador = Usuario.findByUsername("administrador")
		Aviso.list()[0..15].each {
			it.ofertas.each {
				try {
					it.aprobar(administrador)
					it.save(flush:true, failOnError: true)
				} catch (OfertaException e){}							
			} 	
		} 
		
		/* desaprobar 6 avisos, todas las ofertas */
		Aviso.list()[16..22].each {
			it.ofertas.each {
				try {
					it.desaprobar(administrador)
					it.save(flush:true, failOnError: true)
				} catch (OfertaException e){}							
			} 	
		} 
		
		/* de los 16 aprobados, aceptar en 10 todas sus ofertas */
		Aviso.list()[0..9].each {
			def anunciante = it.propietario
			it.ofertas.each {
				try {
					it.aceptar(anunciante)
					it.save(flush:true, failOnError: true)
				} catch (OfertaException e){}
			} 	
		} 
		
		return ""
	
	}
}
