package evaca

class AvisoController extends BaseController implements AvisoExceptionHandler{
	
	def avisoService


	/* create */
	def create() {	
		render(view: 'create', model:avisoService.create())
    }

	
	/* edit */
	def edit() {
		respond view:'create', 
			getViewModel(
				avisoService.edit(params.id)
			)
    }


	/* index */
	def index() {
	
		render(view: 'index', 
			model: [
				avisos: avisoService.search(), 
				lote:[
					consignatarios: Usuario.list().sort{it.nombre}, 
					categorias: Categoria.list().sort{it.nombre}, 
					vendedores: Usuario.list().sort{it.nombre}, 
					razas: Raza.list().sort{it.nombre}
				]
			]
		)

    }

	
	/* save */
	def save(Aviso aviso) {
	
		try {
		
			def action  = [:]
			action.'aprobar()' = {avisoService.aprobar(it)}; 
			action.'rechazar()' = {avisoService.rechazar(it)}; 
			action.'publicar()' = {avisoService.publicar(it)}; 
			action.(params._action_save)(aviso)

		} catch (AvisoException e){

			flash.message = e.message
			render(view: 'create', model:getViewModel(aviso))
			return
		}
		
		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:aviso.id

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
