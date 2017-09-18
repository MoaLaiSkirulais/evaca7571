package evaca

class AvisoController extends BaseController implements AvisoExceptionHandler{
	
	def usuarioService
	def avisoService
	def ofertaService


	/* admin */
	def admin() {		
		respond (view:'admin', getViewModel(avisoService.edit(params.id)))		
    } 


	/* create */
	def create() {	
		render (view: 'create', model: getViewModel(avisoService.create()))
    }


	/* edit */
	def edit() {
		respond (view:'create', getViewModel(avisoService.edit(params.id)))
    }


	/* search */
	def search() {
		println "!!"
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


	/* postular */
	def postular(Aviso aviso) {

		try {

			avisoService.postular(aviso); 

		} catch (AvisoException e){

			flash.message = e.message
			println "pija"
			render(controller:'lote', view: 'create', model:getViewModel(aviso))
			return
		} 

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:aviso.id

    }


	/* aprobar (admin) */
	def aprobar() {
		changeState.call(avisoService.&aprobar)
    }


	/* rechazar */
	def rechazar() {	
		changeState.call(avisoService.&rechazar)
    }


	/* cancelar */
	def cancelar() {
		changeState.call(avisoService.&cancelar)
    }


	/* changeState */
	def changeState = { 
		
		try {
		
			it(params.int('id'));  

		} catch (AvisoException e){

			flash.message = e.message
			redirect action:"edit", id:params.int('id')
			return
		}

		println "bien"
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:params.int('id')
		
	}


	/* show */
	def show() {
 
		def id=params.id
		render(view: 'show', 
			model: [
				aviso: new Aviso().get(id),
				plazos: Plazo.list()
			]
		)
    }

	
	/* find */
	def find() {
 
		render(view: 'find', 
			model: [
				avisos: Aviso.list()
			]
		)
    }
	
	
	/* postular_oferta (ofertante) */
	def postular_oferta(Oferta oferta) { /* tiene que ser un command object */
	
		
		// render oferta.dump()
		// render "\r\n--------------\r\n\r\n"
		// render params
		
		// render "\r\n--------------\r\n\r\n"
		def oferta2 = new Oferta(params)
		oferta2.properties = params
		// render oferta2.dump()

		// render "\r\n--------------\r\n\r\n"
		def oferta3 = Oferta.get(params.id)
		// render oferta3.dump()
		// render "\r\n--------------\r\n\r\n"
		// render oferta3.aviso.dump()

		try {

			def administrador = Usuario.findByUsername("administrador")
			oferta3.aviso.postularOferta(oferta3, administrador)

		} catch (OfertaException e){

			// flash.message = e.message
			render (view: 'show', model:getViewModel(oferta3.aviso))
			return
		}

		// flash.message = "Cambios aplicados con exito"
		// flash.type = "ok"
		// redirect action:"show", id:aviso.id
    }


	/* getViewModel */ /* closure? trait? service? */
	def getViewModel(Aviso aviso){
		[
			aviso: aviso, 
			consignatarios: avisoService.getConsignatarios(), 
			lotes: avisoService.getLotes()
		]
	}


}
