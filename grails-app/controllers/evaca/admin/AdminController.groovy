package evaca

import org.springframework.core.io.Resource

class AdminController 
	extends BaseController 
	implements UsuarioImageHandler, UsuarioExceptionHandler, Helper {
	
	def mySessionService

	/* search_usuarios */
	def search_usuarios() {
		
		render(
			view: 'search_usuarios', 
			model: [
				usuarios: Usuario.list().sort{it.fechaCreacion}, 
			]
		)
		return 

    }
	
	
	/* search_avisos */
	def search_avisos() {
	
		// render avisos: Aviso.list().sort{it.fechaCreacion}; return
	
		render(
			view: 'search_avisos', 
			model: [
				avisos: Aviso.list().sort{it.fechaCreacion}, 
			]
		)
		
		return 

    }

	
	/* search_ofertas */
	def search_ofertas() {
	
		render(
			view: 'search_ofertas', 
			model: [
				ofertas: Oferta.list().sort{it.fechaCreacion}, 
			]
		)
		return 

    }

	
	/* search_resenas */
	def search_resenas() {
		// pija();
		render(
			view: 'search_resenas', 
			model: [
				resenas: Resena.list().sort{it.fechaCreacion}, 
			]
		)
		return 	

    }
	

	/* aprobar_usuario */
	def aprobar_usuario() {
	
		try {
		
			def usuario = getUsuario(params.usuario.id)
			usuario.aprobar(mySessionService.usuario)		
			usuario.save(flush:true, failOnError: true)
			
			successAndRedirect("Cambios aplicados con exito", "search_usuarios")

		} catch (Exception e){
			errorAndRedirect(e.message, "search_usuarios")
		}	

    }
	

	/* desaprobar_usuario */
	def desaprobar_usuario() {

		try {

			def usuario = getUsuario(params.usuario.id)
			usuario.desaprobar(mySessionService.usuario)		
			usuario.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_usuarios")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_usuarios")
		}

    }
	

	/* aprobar_aviso */
	def aprobar_aviso() {
	
		try {

			def aviso = getAviso(params.aviso.id)
			aviso.desaprobar(mySessionService.usuario)
			aviso.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_avisos")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_avisos")
		}

    }


	/* desaprobar_aviso */
	def desaprobar_aviso() {

		try {

			def aviso = getAviso(params.aviso.id)
			aviso.desaprobar(mySessionService.usuario)
			aviso.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_avisos")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_avisos")
		}

    }
	

	/* aprobar_oferta */
	def aprobar_oferta() {
	
		try {

			def oferta = getOferta(params.oferta.id)
			oferta.aprobar(mySessionService.usuario)
			oferta.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_ofertas")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_ofertas")
		}

    }
	

	/* desaprobar_oferta */
	def desaprobar_oferta() {
	
		try {

			def oferta = getOferta(params.oferta.id)
			oferta.desaprobar(mySessionService.usuario)
			oferta.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_ofertas")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_ofertas")
		}


    }
	

	/* aprobar_resena */
	def aprobar_resena() {
	
		try {

			def resena = getResena(params.resena.id)
			resena.aprobar(mySessionService.usuario)
			resena.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_resenas")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_resenas")
		}

    }
	

	/* desaprobar_resena */
	def desaprobar_resena() {
	
		try {

			def resena = getResena(params.resena.id)
			resena.desaprobar(mySessionService.usuario)
			resena.save(flush:true, failOnError: true)

			successAndRedirect("Cambios aplicados con exito", "search_resenas")

		} catch (Exception e){		
			errorAndRedirect(e.message, "search_resenas")
		}

    }
	
	
	
	// def changeState = { 
		
		// render "superpija"
		// return
		
	// }   
	
}