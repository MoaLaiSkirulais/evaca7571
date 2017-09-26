package evaca

import org.springframework.core.io.Resource

class LoteController 
	extends BaseController 
	implements ImageHandler
	
	{
	
	def avisoService
	def loteService
	def uploadRestaurantFeaturedImageService
	def mySessionService
	
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


	/* postular */
	def postular() {

		def lote = new Lote(params)
		lote.propietario = mySessionService.usuario

		try {

			lote.postular()
			lote.save(flush:true, failOnError: true)
			
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id 
			
		} catch (Exception e){

			flash.message = e.message
			render(view: 'create', model:getViewModel(lote))
			return
		}
	    
    }
	
	
	/* actualizar */
	def actualizar(Lote lote) {

		if (!lote){
			render "Lote not found"
			return
		}

		try {

			lote.actualizar()
			lote.save(flush:true, failOnError: true)
			
			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id 
			
		} catch (Exception e){

			flash.message = e.message
			redirect action:"edit", id:lote.id 
			return
		}		
	    
    }
	
	
	/* getViewModel */ 
	def getViewModel(Lote lote){

		[
			lote: lote, 
			categorias: Categoria.list().sort{it.nombre},
			consignatarios: avisoService.getConsignatarios(), 
			plazos: Plazo.list(), 
			razas: Raza.list().sort{it.nombre}
		]
	}


	/* postular_aviso */
	def postular_aviso(Aviso aviso) {
		
		if (!aviso){
			render "No se encontro el aviso"; 		
		}
		
		def lote = aviso.lote
  
		try {		

			lote.postularAviso(aviso)
			aviso.save(flush:true, failOnError: false)

			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id

		} catch (Exception e){
		
			flash.message = e.message
			redirect action:"edit", id:lote.id
			return
		} 
    }

	
	/* cancelar_aviso */
	def cancelar_aviso(Aviso aviso) {
	
		if (!aviso){
			render "No se encontro el aviso"; 		
		}
		
		def lote = aviso.lote
	
		try {
		
			lote.cancelarAviso(aviso, mySessionService.getUsuario())
			aviso.save(flush:true, failOnError: false)

			flash.message = "Cambios aplicados con exito"
			flash.type = "ok"
			redirect action:"edit", id:lote.id

		} catch (AvisoException e){
		
			flash.message = e.message
			redirect action:"edit", id:params.lote.id
			return
		}

    }

		
}
