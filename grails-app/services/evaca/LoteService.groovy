package evaca

import org.springframework.transaction.annotation.Transactional

class LoteService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		[
			lote: new Lote([usuario:mySessionService.usuario]), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]

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
		[
			lote: lote, 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]
		
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

		/* response */
		if (lote.hasErrors()) {

			LoteException error = new LoteException()
			error.model = [
				lote: lote, 
				lotes: Lote.list(),
				categorias: Categoria.list(),
				razas: Raza.list()
			]
			throw error
		}
		
	}		
	

	/* search */
	@Transactional(readOnly = true)
	def search() {
	
		// def avisos = Aviso.createCriteria().list (params) {
		def lotes = Lote.createCriteria().list(){
			usuario{eq("id", mySessionService?.usuario.id.toLong())}
			// consignatario{eq("id", params.consignatario.id.toLong())}
			
		}
		
		return [lotes:lotes]

	}

	
	/* read */
	def read() {
	}	

	
}
