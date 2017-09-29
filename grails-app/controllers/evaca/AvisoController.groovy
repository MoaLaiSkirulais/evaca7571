package evaca

class AvisoController extends BaseController implements AvisoExceptionHandler{
	
	def usuarioService
	def avisoService
	def ofertaService
	def mySessionService

	/* admin */
	def admin() {		
		respond (view:'admin', getViewModel(avisoService.edit(params.id)))		
    } 


	/** 
	 * create 
	 */
	def create() {	
		render (view: 'create', model: getViewModel(avisoService.create()))
    }


	/** 
	 * edit 
	 */
	def edit() {
		respond (view:'create', getViewModel(avisoService.edit(params.id)))
    }


	/** 
	 * search 
	 */
	def search() {

		render(
			view: 'search', 
			model: [
				usuario: usuarioService.edit(1), 
				avisos: avisoService.search(params), 
				lote:[
					consignatarios: Usuario.list().sort{it.nombre}, 
					categorias: Categoria.list().sort{it.nombre}, 
					vendedores: Usuario.list().sort{it.nombre}, 
					razas: Raza.list().sort{it.nombre}
				]
			]
		)

    }


	/* 
	 * postular 
	 */
	def postular(Aviso aviso) {

		try {

			avisoService.postular(aviso); 

		} catch (AvisoException e){

			flash.message = e.message
			render(controller:'lote', view: 'create', model:getViewModel(aviso))
			return
		} 

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:aviso.id

    }


	/* aprobar (admin) */
	def aprobar() {
	
		def aviso = Aviso.get(params.aviso.id)
		if (!aviso){
			render ("No se encontró el aviso")
			return
		}
		
		try {
		
			aviso.aprobar(); 
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect controller:'lote', action:"edit", id:aviso.id

		} catch (AvisoException e){

			flash.message = e.message
			redirect controller:'lote', action:"edit", id:aviso.id
			return
		} 

		
    }


	/* rechazar */
	def rechazar() {	
		// changeState.call(avisoService.&rechazar)
    }


	/* cancelar */
	def cancelar() {
		// changeState.call(avisoService.&cancelar)
    }


	/* changeState */
	def changeState = { 
		
		// try {
		
			// it(params.int('id'));  

		// } catch (AvisoException e){

			// flash.message = e.message
			// redirect action:"edit", id:params.int('id')
			// return
		// }

		// flash.message = "Cambios aplicados con exito"
		// flash.type = "ok"
		// redirect action:"edit", id:params.int('id')
		
	}


	/* show */
	def show() {
 
		def id=params.id
		def model = [
				aviso: new Aviso().get(id),
				plazos: Plazo.list()
			]
		
		//render model.aviso.dump(); return;		
		render(view: 'show', model: model)
    }

	
	/** 
	 * find 
	 */
	def find() {
 
		render(view: 'find', 
			model: [
				avisos: Aviso.list()
			]
		)
    }
	
	
	/** 
	 * postular_oferta (ofertante) 
	 */
	def postular_oferta() { /* tiene que ser un command object! */
	
		def aviso = Aviso.get(params.aviso.id)
		if (!aviso){
			render ("No se encontró el aviso")
			return
		}

		def oferta = new Oferta(params)
		oferta.propietario = mySessionService.getUsuario()

		try {

			aviso.postularOferta(oferta, mySessionService.getUsuario())
			aviso.save(flush:true, failOnError: true)

		} catch (Exception e){

			flash.message = e.message
			def model = [
				aviso: aviso,
				plazos: Plazo.list()
			]
			render (view: 'show', model:model)
			return
		}

		// render ("\r\n---- Bien! -----\r\n"); return
		flash.message = "La oferta deberá ser aprobada por la administración"
		flash.type = "ok"
		redirect action:"show", id:aviso.id
    }
	

	/** 
	 * aprobar_oferta (ofertante) 
	 */
	def aprobar_oferta() { 
	
		def oferta = Oferta.get(params.oferta.id)
		if (!oferta){
			render ("No se encontró la oferta")
			return
		}

		def aviso = oferta.aviso
		
		try {

			def administrador = Usuario.findByUsername("administrador")
			aviso.aprobarOferta(oferta, administrador)
			aviso.save(flush:true, failOnError: true)

		} catch (Exception e){

			// render ("\r\n----Exception!----\r\n" + e.dump() + getViewModel(aviso) + "\r\n-------\r\n"); return;
			flash.message = e.message
			def model = [
				aviso: aviso,
				plazos: Plazo.list()
			]
			render (view: 'show', model:model)
			return
		}

		// render ("\r\n---- Bien! -----\r\n"); return
		flash.message = "La fue aprobada"
		flash.type = "ok"
		redirect action:"show", id:aviso.id
    }
	

	/** 
	 * aceptar_oferta (ofertante) 
	 */
	def aceptar_oferta() { 
	
		def oferta = Oferta.get(params.oferta.id)
		if (!oferta){
			render ("No se encontró la oferta")
			return
		}

		def aviso = oferta.aviso
		
		try {

			aviso.aceptarOferta(oferta, mySessionService.getUsuario())
			aviso.save(flush:true, failOnError: true)

		} catch (Exception e){

			// render ("\r\n----Exception!----\r\n" + e.dump() + getViewModel(aviso) + "\r\n-------\r\n"); return;
			flash.message = e.message
			def model = [
				aviso: aviso,
				plazos: Plazo.list()
			]
			render (view: 'show', model:model)
			return
		}

		// render ("\r\n---- Bien! -----\r\n"); return
		flash.message = "La oferta fue aprobada. El lote está vendido."
		flash.type = "ok"
		redirect action:"show", id:aviso.id
    }


	/** 
	 * getViewModel 
	 */ 
	def getViewModel(Aviso aviso){
		[
			aviso: aviso, 
			consignatarios: avisoService.getConsignatarios(), 
			lotes: avisoService.getLotes()
		]
	}


}
