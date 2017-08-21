package evaca

import org.springframework.transaction.annotation.Transactional

class LoteService {
	
	def mySessionService
	
	/* create */
	def create() {
		return new Lote([usuario:mySessionService.usuario])
	}

	
	/* edit */
	def edit(id) {
  
		/* existencia */
		def lote = new Lote().get(id) 
		if (!lote){
			throw new LoteNotFoundException()
		}

		/* valida owner */
		if (mySessionService.usuario != lote.usuario){
			throw new LoteNotFoundException(message: "Solo puede editar sus propios lotes")
		}

		/* response */
		return lote
		
	}
	
	
	/* save */
	def save(Lote lote) {

		/* valida owner */
		if (mySessionService.usuario != lote.usuario){
			throw new LoteNotFoundException(message: "Solo puede editar sus propios lotes")
			/* queda medio feo esto pero donde debe ir? */
		}

		/* save */
		lote.usuario = mySessionService.usuario
		lote.save(flush:true, failOnError: false)

		if (lote.hasErrors()) {
			throw new LoteException()		
		}
		
	}		
	

	/* search */
	@Transactional(readOnly = true)
	def search(params) {
	
		def lotes = Lote.createCriteria().list(){
				
			if (params?.usuario?.id) {
				// println "hehe"
				usuario { eq("id", params.usuario.id.toLong())}
			}
		
			// usuario{eq("id", mySessionService?.usuario?.id?.toLong())}
			// consignatario{eq("id", params.consignatario.id.toLong())}
			
		}
		
		return lotes

	}

	
	/* read */
	def read() {
	}	

	
}
