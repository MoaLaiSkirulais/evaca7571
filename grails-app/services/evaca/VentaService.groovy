package evaca

class VentaException extends RuntimeException {
	String message
	Map model
}

class VentaService {
	
	def mySessionService
	
	/* create */
	def create() {
	
		def venta = new Venta()
		venta.usuario = mySessionService.usuario

		def model = [
			venta: venta, 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]
		
		[model: model]
	}
	
	
	/* save */
	def save(Venta venta) {
	
		venta.usuario = mySessionService.usuario
		venta.save(flush:true)

		def model = [
			venta: venta, 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]

		if (venta.hasErrors()) {
			VentaException error = new VentaException(message:"Errors!")
			error.model = model
			throw error;
		}

		/* crea la venta si es tbState=V */
		// println venta.tbState
		
	}		
	
}
