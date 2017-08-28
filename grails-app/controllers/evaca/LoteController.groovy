package evaca

import org.springframework.core.io.Resource

class LoteController 
	extends BaseController 
	implements ImageHandler
	
	{
	
	def avisoService
	def loteService
	def uploadRestaurantFeaturedImageService

	
	/* admin */
	def admin() {		
		respond (
			view:'admin', 
			getViewModel(loteService.edit(params.id))
		)
    } 
	

	/* create */
	def create() {		    
		respond (
			view:'create', 
			getViewModel(loteService.create())
		)
    }

	
	/* edit */
	def edit() {	
		println "edit"
		respond (
			view: 'edit', 
			getViewModel(loteService.edit(params.id))
		)
    }


	/* search */
	def search() {	

		render(
			view: 'search', 
			model: [
				lotes : loteService.search(params)			
			]	
		)
    }


	/* save */
	def save(Lote lote) {
	// def save(SaveCommand cmd) {

		try {

			loteService.save(lote)
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id
 
		} catch (LoteException e){

			flash.message = e.message
			render(view: 'create', model:getViewModel(lote))
			return
		}
	    
    }
	
	
	/* getViewModel */ 
	def getViewModel(Lote lote){

		[
			lote: lote, 
			categorias: Categoria.list().sort{it.nombre},
			razas: Raza.list().sort{it.nombre},
			aviso: new Aviso().get(3)
		]
	}


	/* postular */
	def postular(Aviso aviso) {

		try {

			avisoService.postular(aviso); 

		} catch (AvisoException e){

			flash.message = e.message
			render(view: 'edit', model:getViewModel(aviso.lote))
			return
		} 

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:aviso.lote.id

    }

	
	/* cancelar */
	def cancelar() {
	
		try {
		
			avisoService.cancelar(params.int('id'));  

		} catch (AvisoException e){
		
			flash.message = e.message
			redirect action:"edit", id:params.lote.id
			return
		}

		flash.message = "Cambios aplicados con exito"
		flash.type = "ok"
		redirect action:"edit", id:params.lote.id
    }

		
}
