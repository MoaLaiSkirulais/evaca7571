package evaca
 
trait NotFoundExceptionHandler {
    def exception(UsuarioNotLoggedException e) {			
		flash.message = e.message        
		redirect controller: 'usuario', action:"newlogin"
		return
	}
}


