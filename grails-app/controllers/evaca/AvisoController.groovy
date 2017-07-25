package evaca

class AvisoController extends BaseController implements AvisoExceptionHandler{
	
	def avisoService


	/* create */
	def create() {	
	    avisoService.create()
    }

	
	/* edit */
	def edit() {
		respond view:'create', avisoService.edit(params.id)
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

		avisoService.save(aviso)
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
	
	/* changeState */
	def changeState() {

		def auxState = params._action_changeState as AvisoState
		avisoService.changeState(params.id, auxState)
		flash.message = "Estado cambió con éxito!"
		flash.type = "ok"
		redirect action:"edit", id:params.id
	}

}
