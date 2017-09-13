package evaca

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/**
 * ResenaReader 
 */	
class ResenaReader {

	
	/**
	 * loadFromCsv 
	 */
	public loadFromCsv(String path){
	
		Resena.executeUpdate('delete from Respuesta')
		Resena.executeUpdate('delete from Resena')

		File csvFile = new File(LocalSystem.getDataResource("/mock/csv/resenas.csv"));
		def i = 0
		csvFile.splitEachLine(',') { fields ->
		}
		
		/* reseñar todas los avisos vendidos, igual voy a chocar */
		def administrador = Usuario.findByUsername("administrador")
		Aviso.list().each { aviso ->
		
			// println aviso.dump()
			
			/* nueva resena */
			def resena = new Resena()
			resena.propietario = aviso.propietario
			resena.prepare()
			// resena.venta = it
			resena.puntaje = 4
			
			/* preguntas */		
			resena.respuestas[0].puntaje = 5
			resena.respuestas[0].respuesta = "aceptable"
			
			resena.respuestas[1].puntaje = 3  /* seria bueno encadenar con setters aca alguna vez! */
			resena.respuestas[1].respuesta = "bueno"
			
			resena.respuestas[2].puntaje = 1
			resena.respuestas[2].respuesta = "esta bien"
			
			resena.respuestas[3].puntaje = 2
			resena.respuestas[3].respuesta = "tal vez"
			
			resena.respuestas[4].puntaje = 2
			resena.respuestas[4].respuesta = "sin comentarios"
			
			try {
				aviso.postularResena(resena)
				aviso.save(flush:true, failOnError: true)
			} catch (AvisoException e){
				println e
			}

		} 
		
		/* aprobar todas */	
		/* no va por el AR parece ? quizas este bien */	
		Resena.list().each { resena -> 
			try {
				resena.aprobar(administrador)
				resena.save(flush:true, failOnError: true)
			} catch (OfertaException e){
				println e
			}
			
		} 
		
	
	}
}
