package evaca

class ResenaException extends RuntimeException {
	String message
	Map model
}

class ResenaService {

	def mySessionService

	/* create */
	def create() {

		def resena = new Resena()
		resena.usuario = mySessionService.usuario
		resena.venta = Venta.list()[0]
		resena.prepare() /* este prepare podria hacer mas cosas, entre ellas validar en el domain */
		def model = [
			resena: resena
		]
		
		[model: model]
	}	
	
	/* save */
	def save(Resena resena) {
	
		resena.usuario = mySessionService.usuario //tal vez no sea necesario ya que viene del create 
		resena.save(flush:true)

		def model = [
			resena: resena
		]

		if (resena.hasErrors()) {
			println "errores"
			ResenaException error = new ResenaException(message:"Errors!")
			error.model = model
			throw error;
		}
		
	}		
	
	
	/* read */
	def read() {
	}	

	
}
