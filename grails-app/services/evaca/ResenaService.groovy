package evaca


/* ResenaService */
class ResenaService {

	def mySessionService
	
	
	/* getVentas */
	def getVentas() {
		Venta.list()
	}


	/* create */
	def create() {

		def resena = new Resena()
		resena.propietario = mySessionService.usuario
		resena.venta = Venta.list()[0]
		resena.prepare() /* este prepare podria hacer mas cosas, entre ellas validar en el domain */
		return resena

	}	
	
	
	/* edit */
	def edit(id) {

		def resena = new Resena().get(id)
		if (!resena){
			throw new ResenaException()
		}

		return resena
	}

	
	/* postular (oferente) */
	def postular(Resena resena) {
	
		/* fuerza el propietario al logged */
		resena.propietario = mySessionService.usuario /* el grave problema! */
		resena.changeState(ResenaState.POSTULADO, mySessionService.usuario)

		/* si existe la venta esta bien */

		/* el reseño es el comprador */
		if (resena.propietario != resena.venta.oferta.propietario){
			throw new ResenaException(message: "Solo el comprador puede hacer la reseña")
		}
		
		// /* el reseño aun no reseño */
		// if (resena.propietario != resena.venta.oferta.propietario){
			// throw new ResenaException(message: "Solo el comprador puede hacer la reseña")
		// }


		/* save */
		resena.save(flush:true, failOnError: false)
		if (resena.hasErrors()) {
			throw new ResenaException()
		}
		
	}
	

	/* aprobar (vendedor/comprador) */
	def aprobar(Long id) {
	
		def resena = new Resena().get(id)
		if (!resena){
			throw new ResenaException();
		}

		resena.changeState(ResenaState.APROBADO, mySessionService.usuario)
		resena.save(flush:true, failOnError: false)
	}
	

	/* desaprobar (vendedor/comprador) */
	def desaprobar(Long id) {
	
		def resena = new Resena().get(id)
		if (!resena){
			throw new ResenaException();
		}

		resena.changeState(ResenaState.DESAPROBADO, mySessionService.usuario)
		resena.save(flush:true, failOnError: false)
	}
	
	
}
