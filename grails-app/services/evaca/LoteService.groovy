package evaca

import org.springframework.transaction.annotation.Transactional

class LoteService {
	
	def mySessionService
	
	/* create */
	def create() {

		def lote = new Lote([propietario: mySessionService.usuario])
		lote.aviso = new Aviso([propietario: lote.propietario])
		return lote
	}

	
	/* edit */
	def edit(id) {
  
		/* existencia */
		def lote = new Lote().get(id) 
		if (!lote){
			throw new LoteNotFoundException()
		}

		/* valida owner */
		if (mySessionService.usuario != lote.propietario){
			throw new LoteNotFoundException(message: "Solo puede editar sus propios lotes")
		}

		/* response */
		return lote
		
	}
	
	
	/* save */
	def save(Lote lote) {
	// def save(SaveCommand cmd) {
	
		println mySessionService.usuario
		println lote.propietario

		/* valida owner */
		if (mySessionService.usuario != lote.propietario){
			throw new LoteNotFoundException(message: "Solo puede editar sus propios lotes")
			/* queda medio feo esto pero donde debe ir? */
		}

		/* save */
		// lote.properties = cmd.properties
		if (!lote.aviso){
			lote.aviso = new Aviso([propietario: lote.propietario])
		}

		lote.propietario = mySessionService.usuario
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
