package evaca

class AvisoController extends BaseController implements AvisoExceptionHandler{
	
	def avisoService


	/* create */
	def create() {	
		render(
			view: 'create', 
			model: getViewModel(avisoService.create())			
		)
    }

	
	/* edit */
	def edit() {
		respond(
			view:'create', 
			getViewModel(avisoService.edit(params.id))
		)
    }


	/* index */
	def index() {
	
		render(view: 'index', 
			model: [
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
			render(view: 'create', model:getViewModel(aviso))
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
	
	
	/* getViewModel */ /* closure? trait? service? */
	def getViewModel(Aviso aviso){
		[
			aviso: aviso, 
			consignatarios: avisoService.getConsignatarios(), 
			lotes: avisoService.getLotes()
		]
	}


}
