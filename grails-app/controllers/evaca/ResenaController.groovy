package evaca

class ResenaController {
	
	def resenaService
	def mySessionService	
	
	/** 
	 * admin 
	 */
	def admin() {
		render (view: 'admin', model: getViewModel(resenaService.edit(params.id)))
    }

	
	/** 
	 * create 
	 */
	def create() {
		render (view: 'create', model: getViewModel(resenaService.create()))
    }


	/** 
	 * edit 
	 */
	def edit() {
		respond (view:'create', getViewModel(resenaService.edit(params.id)))
    }

	
	/**
	 * search 
	 */
	def search() {
		
		def resenas = Oferta.createCriteria().list(){
		
			if (mySessionService.usuario.id) {
				propietario{eq("id", mySessionService.usuario.id)}
			}
		}

		render(view: 'search', model: [resenas : resenas])
    }

	
	/** 
	 * aprobar (admin) 
	 */
	def aprobar() {
	
		def resena = Resena.get(params.resena.id)
		if (!resena){
			render ("No se encontró la resena")
			return
		}

		def aviso = resena.aviso
		
		try {

			def administrador = Usuario.findByUsername("administrador")
			aviso.aprobarResena(resena, administrador)
			aviso.save(flush:true, failOnError: true)

		} catch (Exception e){

			render ("\r\n----Exception!----\r\n" + e.dump() +  "\r\n-------\r\n"); return;
			flash.message = e.message
			def model = [
				aviso: aviso,
				plazos: Plazo.list()
			]
			render (view: 'show', model:model)
			return
		}

		render ("\r\n---- Bien! -----\r\n"); return
		flash.message = "La fue aprobada"
		flash.type = "ok"
		redirect action:"show", id:aviso.id
		
    }

	
	/** 
	 * desaprobar (admin) 
	 */
	def desaprobar() {
		// changeState.call(resenaService.&desaprobar)
    }
	

	/** 
	 * _postular (vendedor | comprador) 
	 */
	def _postular(Resena resena) {

		try {

			resenaService.postular(resena);  

		} catch (ResenaException e){

			flash.message = e.message
			render(
				view: 'create', 
				model:getViewModel(resena)
			)
			return
		}

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:resena.id
    }
	
	
	/* postular */
	def postular() { /* tiene que ser un command object! */
	
		// render params; return;
	
		def aviso = Aviso.get(params.aviso.id)
		if (!aviso){
			render ("No se encontró el aviso")
			return
		}

		def resena = new Resena()
		resena.prepare()
		resena.properties = params
		resena.propietario = mySessionService.getUsuario()

		try {

			def administrador = Usuario.findByUsername("administrador")
			aviso.postularResena(resena)
			aviso.save(flush:true, failOnError: true)

		} catch (Exception e){

			render ("\r\n----Exception!----\r\n" + e.dump() + "\r\n-------\r\n"); return;
			flash.message = e.message
			def model = [
				aviso: aviso,
				plazos: Plazo.list()
			]
			render (view: 'show', model:model)
			return
		}

		render ("\r\n---- Bien! -----\r\n"); return
		flash.message = "La oferta deberá ser aprobada por la administración"
		flash.type = "ok"
		redirect action:"show", id:aviso.id
    }
	
	
	/** 
	 * changeState 
	 */
	def changeState = { 
		
		// try {			
			// it(params.int('id'));  
		// } catch (ResenaException e){
			// flash.message = e.message
			// redirect action:"edit", id:params.int('id')
			// return
		// }

		// flash.message = "Cambios aplicados con exito"
		// flash.type = "ok"
		// redirect action:"edit", id:params.int('id')
		
	}   

	
	/** 
	 * getViewModel 
	 */ 
	def getViewModel(Resena resena){
		[
			resena: resena
		]
	}
	

}
