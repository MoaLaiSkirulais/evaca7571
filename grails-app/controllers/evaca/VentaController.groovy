package evaca

class VentaController {
	
	def ventaService

	/* create */
	def create() {
		
		try {
			
			ventaService.create()
		
		} catch (UserRegistrationException ure) {        

			flash.message = ure.message        
			redirect controller: 'usuario', action:"newlogin	"
		}

    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			venta: new Venta().get(id), 
			avisos: Aviso.list(), 
			plazos: Plazo.list()
		]

		respond view:'create', [model:model]
    }
	
	/* index */
	def index() {

		def ventas = Venta.list()
		render(view: 'index', model: [ventas:ventas])
    }

	/* save */
	def save(Venta venta) {		
		// venta.aviso = null
		ventaService.save(venta)
		redirect action:"edit", id:venta.id
    }

	/* exception */
	def exception(UserRegistrationException error) {
		flash.message = error.message        
		redirect controller: 'usuario', action:"newlogin"
    }

	/* exception */
	def exception(VentaException error) {
		flash.message = "error"
		respond view:'create', [model:error.model]
    }


}
