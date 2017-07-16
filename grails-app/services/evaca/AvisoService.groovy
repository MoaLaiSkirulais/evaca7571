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
		println aviso.tbState
		def model = [
			aviso: aviso, 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]
		// println "--- edit ---"
		println aviso.id
		println aviso.tbState
		println "!!!"
		// render "!!!"
		// return
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
		println "---" + newTbState
		//aviso.changeState(AvisoState.PUBLICADO)
		aviso.changeState(newTbState, mySessionService.usuario)
		//aviso.precio = 10
		aviso.save(flush:true, failOnError: true)	
		//println aviso.precio
		
		// def model = [
			// aviso: aviso, 
			// avisos: Aviso.list(),
			// categorias: Categoria.list(),
			// razas: Raza.list()
		// ]
    }
	

	/* search */
	def search() {
	
		// if (!mySessionService.isAdministrator()) {
			// throw new UserRegistrationException(message:"You must be Admin to perform this action")
		// }

		// def lotes = Lote.list()
		// return [lotes:lotes]

	}
	
}
