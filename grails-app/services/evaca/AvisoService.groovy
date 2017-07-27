package evaca

class AvisoService {
	
	def mySessionService

	
	/* create */
	def create() {

		[
			aviso: new Aviso(), 
			consignatarios: Usuario.list(),
			lotes: Lote.list()
		]
	}

	
	/* edit */
	def edit(id) {
	
		def consignatarios = Usuario.createCriteria().list () {
			eq("profile", UsuarioProfile.CONSIGNATARIO)
		}

		[
			aviso: new Aviso().get(id), , 
			consignatarios: consignatarios,
			lotes: Lote.list()
		]

		
	}
	
	
	/* save */
	def save(Aviso aviso) {

		aviso.save(flush:true)

		if (aviso.hasErrors()) {

			def consignatarios = Usuario.createCriteria().list () {
				eq("profile", UsuarioProfile.CONSIGNATARIO)
			}

			AvisoException error = new AvisoException()
			error.model = [
				aviso: aviso, 
				consignatarios: consignatarios,
				lotes: Lote.list()
			]
			throw error;
		}
		
	}
	
	
	/* changeState */
	def changeState(id, AvisoState newTbState) { /* si le mando la instancia? vale para todos y para el save */

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

			// lote{usuario{eq("id", mySessionService?.usuario.id.toLong())}}
	
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
