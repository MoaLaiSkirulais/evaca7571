package evaca

class ResenaController {
	
	def resenaService
	
	
	/* admin */
	def admin() {
		render (view: 'admin', model: getViewModel(resenaService.edit(params.id)))
    }

	
	/* create */
	def create() {
		render (view: 'create', model: getViewModel(resenaService.create()))
    }


	/* edit */
	def edit() {
		respond (view:'create', getViewModel(resenaService.edit(params.id)))
    }

	
	/* index */
	def index() {

		def resenas = Resena.list()

		render(view: 'index', 
		model: [
				resenas:resenas
			]
		)
    }

	
	/* aprobar (admin) */
	def aprobar() {
		changeState.call(resenaService.&aprobar)
    }

	
	/* desaprobar (admin) */
	def desaprobar() {
		changeState.call(resenaService.&desaprobar)
    }
	

	/* postular (vendedor | comprador) */
	def postular(Resena resena) {

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
	
	
	/* changeState */
	def changeState = { 
		
		try {			
			it(params.int('id'));  
		} catch (ResenaException e){
			flash.message = e.message
			redirect action:"edit", id:params.int('id')
			return
		}

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:params.int('id')
		
	}   

	
	/* getViewModel */ 
	def getViewModel(Resena resena){
		[
			resena: resena
		]
	}
	

}
