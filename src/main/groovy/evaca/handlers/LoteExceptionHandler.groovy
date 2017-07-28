package evaca
 
trait LoteExceptionHandler {
	
	/* LoteException */
	def exception(LoteException error) {
		flash.message = error.message
		redirect(action: "index")
    }
	
	/* LoteNotFoundException */
	def exception(LoteNotFoundException error) {
		flash.message = error.message
		redirect(action: "index")
    }
	 

}


