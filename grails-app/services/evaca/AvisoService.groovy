package evaca

class AvisoService {
	
	def mySessionService

	
	/* create */
	def create() {
			
		def model = [
			lote: new Aviso(), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]

		[model: model]
	}

	
	/* edit */
	def edit(id) {

	    def aviso = new Aviso().get(id)
		aviso.refresh()

		def model = [
			aviso: aviso, 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]

		return [model: model]
	}
	
	
	/* save */
	def save(Aviso aviso) {
	
		aviso.save(flush:true)

		def model = [
			aviso: aviso, 
			avisos: Aviso.list(),
			categorias: Categoria.list(),
			razas: Raza.list()
		]

		if (aviso.hasErrors()) {
			DomainException error = new DomainException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}
	
	
	/* changeState */
	def changeState(id, AvisoState newTbState) {

		def aviso = new Aviso().get(id)
		if (!aviso){
			throw new DomainException(message:"Aviso not found")
		}
		aviso.changeState(newTbState, mySessionService.usuario)
		aviso.save(flush:true, failOnError: true)	
	
    }
	

	/* search */
	def search(params) {

		def avisos = Aviso.createCriteria().list () {
		
			// aviso{eq("id", mySessionService.aviso.id.toLong())}

			if (params?.lote?.usuario?.id) {
				lote{usuario{eq("id", params.lote.usuario.id.toLong())}}
			}

			if (params?.consignatario?.id) {
				consignatario{eq("id", params.consignatario.id.toLong())}
			}

		}
		
		return avisos

	}
	
}
