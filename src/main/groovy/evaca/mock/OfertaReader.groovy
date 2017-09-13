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

		/* listado de ofertantes, plazo y precio que van a aplicar a los avisos */
		File csvFile = new File(LocalSystem.getDataResource("/mock/csv/ofertas.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->

			def ofertante = Usuario.findByUsername(fields[0].trim())		
			
			Aviso.list().each { aviso ->
			
				def oferta = new Oferta(propietario:ofertante)
				oferta.plazo = Plazo.findByNombre(fields[4].trim())
				oferta.precio = Float.parseFloat(fields[3].trim())

				try {
					aviso.postularOferta(oferta, ofertante)
					aviso.save(flush:true, failOnError: true)
				} catch (AvisoException e){}
				
			} 

		}

		/* aprobar 16 avisos, todas las ofertas */
		def administrador = Usuario.findByUsername("administrador")
		Aviso.list()[0..15].each { aviso ->
			aviso.ofertas.each { oferta -> 
				try {
					aviso.aprobarOferta(oferta, administrador)
					aviso.save(flush:true, failOnError: true)
				} catch (AvisoException e){}							
			} 	
		} 
		
		/* desaprobar 6 avisos, todas las ofertas */
		Aviso.list()[16..22].each { aviso ->
			aviso.ofertas.each { oferta -> 
				try {
					aviso.desaprobarOferta(oferta, administrador)
					aviso.save(flush:true, failOnError: true)
				} catch (AvisoException e){}
			} 	
		} 
		
		/* de los 16 avisos aprobados, aceptar en 10 todas sus ofertas */
		Aviso.list()[0..9].each {aviso ->
			def anunciante = aviso.propietario
			aviso.ofertas.each { oferta -> 
				try {
					aviso.aceptarOferta(oferta, anunciante)
					aviso.save(flush:true, failOnError: true)
				} catch (AvisoException e){}
			} 	
		} 
		
		return ""
	
	}
}
