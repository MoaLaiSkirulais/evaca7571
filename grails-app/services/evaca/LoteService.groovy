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
			throw new LoteNotFoundException(message:"No puede editar un lote no propio")
		}

		/* response */
		return lote
		
	}
	
	
	/* save */
	def save(Lote lote) {

		/* valida owner */
		if (mySessionService.usuario != lote.usuario){
			throw new LoteNotFoundException(message:"No puede editar un lote no propio")
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
	def search() {
	
		// def avisos = Aviso.createCriteria().list (params) {
		def lotes = Lote.createCriteria().list(){
			usuario{eq("id", mySessionService?.usuario?.id?.toLong())}
			// consignatario{eq("id", params.consignatario.id.toLong())}
			
		}
		
		return [lotes:lotes]

	}

	
	/* read */
	def read() {
	}	

	
}
