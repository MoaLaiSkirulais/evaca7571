package evaca
 
trait LoteExceptionHandler {
	
	/* LoteExceptionHandler */
	def exception(LoteException error) {
		// render "todo mal!!!!!!!!!"
		// render "todo mal!!!!!!!!!"
		println "--->" + error.model
		println "------->" + error.model.lote.errors
		flash.message = error.message
		render(view: 'create', model: error.model)
    }
	

}


