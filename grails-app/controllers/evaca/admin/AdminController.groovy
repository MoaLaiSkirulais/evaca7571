package evaca

import org.springframework.core.io.Resource

class AdminController extends BaseController implements UsuarioImageHandler, UsuarioExceptionHandler{ 
	
	def mySessionService

	/* search_usuarios */
	def search_usuarios() {
		
		render "search_usuarios"
		return 

    }
	
	
	/* search_avisos */
	def search_avisos() {
	
		render "search_avisos"
		return 

    }

	
	/* search_ofertas */
	def search_ofertas() {
	
		render "search_ofertas"
		return 

    }

	
	/* search_resenas */
	def search_resenas() {
	
		render "search_resenas"
		return 	

    }
	

	/* aprobar_usuario */
	def aprobar_usuario() {
	
		render "aprobar_usuario"
		return 	

    }
	

	/* desaprobar_usuario */
	def desaprobar_usuario() {

		render "desaprobar_usuario"
		return 

    }
	

	/* aprobar_aviso */
	def aprobar_aviso() {
	
		render "aprobar_aviso"
		return 	

    }
	

	/* desaprobar_aviso */
	def desaprobar_aviso() {
	
		render "desaprobar_aviso"
		return 	

    }
	

	/* aprobar_oferta */
	def aprobar_oferta() {
	
		render "aprobar_oferta"
		return 

    }
	

	/* desaprobar_oferta */
	def desaprobar_oferta() {
	
		render "desaprobar_oferta"
		return 

    }
	

	/* aprobar_resena */
	def aprobar_resena() {
	
		render "aprobar_resena"
		return 

    }
	

	/* desaprobar_resena */
	def desaprobar_resena() {
	
		render "desaprobar_resena"
		return 

    }
	
}