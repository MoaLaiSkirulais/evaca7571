package evaca

import org.springframework.transaction.annotation.Transactional

class LoteService {
	
	def mySessionService
	
	/* create */
	def create() {
			
		def model = [
			lote: new Lote([usuario:mySessionService.usuario]), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]

		[model: model]
	}

	
	/* edit */
	def edit(id) {

		def model = [
			lote: new Lote().get(id), 
			lotes: Lote.list(),
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre}
		]
		return [model: model]
	}
	
	
	/* save */
	def save(Lote lote) {
	
		lote.usuario = mySessionService.usuario
		lote.save(flush:true)

		def model = [
			lote: lote, 
			lotes: Lote.list(),
			categorias: Categoria.list(),
			razas: Raza.list()
		]

		if (lote.hasErrors()) {
			DomainException error = new DomainException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	

	/* search */
	@Transactional(readOnly = true)
	def search() {
	
		// def avisos = Aviso.createCriteria().list (params) {
		def lotes = Lote.createCriteria().list(){
			usuario{eq("id", mySessionService.usuario.id.toLong())}
			// consignatario{eq("id", params.consignatario.id.toLong())}
			
		}
		
		return [lotes:lotes]

	}

	
	/* read */
	def read() {
	}	

	
}
