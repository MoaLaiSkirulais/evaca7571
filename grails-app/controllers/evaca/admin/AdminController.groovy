package evaca

import org.springframework.core.io.Resource

class AdminController 
	extends BaseController 
	// implements UsuarioImageHandler, UsuarioExceptionHandler, Helper {
	implements UsuarioImageHandler, UsuarioExceptionHandler {
	
	def mySessionService

	/* search_usuarios */
	def search_usuarios() {
	
		def usuarios = Usuario.createCriteria().list () {
		
			if (params?.filter?.username) {
				like("username", params.filter.username)
			}

			if (params?.filter?.state) {
				def aux = params.filter.state as UsuarioState
				eq("state", aux)
			}

			if (params?.filter?.profile) {
				def aux = params.filter.profile as UsuarioProfile
				eq("profile", aux)
			}

		}
		
		render(
			view: 'search_usuarios', 
			model: [
				usuarios: usuarios.sort{it.fechaCreacion}.reverse(), 
				filter :[
					profiles: UsuarioProfile.values(),  
					states: UsuarioState.values()	
				]
			]
		)
		return 

    }
	
	
	/* search_avisos */
	def search_avisos() {
	
		def avisos = Aviso.createCriteria().list () {
		
			if (params?.filter?.username) {
				// like("username", params.filter.username)
				propietario{eq("username", params.filter.username)}
			}

			if (params?.filter?.state) {
				def aux = params.filter.state as AvisoState
				eq("state", aux)
			}

			if (params?.filter?.consignatario?.id) {
				consignatario{eq("id", params.filter.consignatario.id.toLong())}
			}

			if (params?.filter?.plazo?.id) {
				plazo{eq("id", params.filter.plazo.id.toLong())}
			}

		}
	
		/* filters */
		def consignatarios = Usuario.createCriteria().list () {
			eq("profile", UsuarioProfile.CONSIGNATARIO)
		}
		
		render(
			view: 'search_avisos', 
			model: [
				avisos: avisos.sort{it.fechaCreacion}.reverse(), 
				filter :[
					states: AvisoState.values(), 	
					consignatarios: consignatarios, 
					plazos: Plazo.list().sort{it.nombre}
				]
			]
		)
		
		return 

    }

	
	/* search_ofertas */
	def search_ofertas() {
	
		def ofertas = Oferta.createCriteria().list () {
		
			if (params?.filter?.aviso?.id) {
				aviso{eq("id", params.filter.aviso.id.toLong())}
			}

			if (params?.filter?.username) {
				propietario{eq("username", params.filter.username)}
			}

			if (params?.filter?.state) {
				def aux = params.filter.state as OfertaState
				eq("state", aux)
			}

		}

		render(
			view: 'search_ofertas', 
			model: [
				ofertas: ofertas.sort{it.fechaCreacion}.reverse(), 
				filter :[
					states: OfertaState.values()
				]
			]
		)
		return 

    }

	
	/* search_resenas */
	def search_resenas() {

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
			aviso.aprobar(mySessionService.usuario)
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
		
		// return
		
	// }   
	
	
	/* ---------------------------------------------------------------------- */
	/* esto deberia estar en usuario pero no refresca bien grails los cambios */
	/* ---------------------------------------------------------------------- */	
	
	/* getUsuario */ 
	Usuario getUsuario(usuarioId) {	
	
		def usuario = new Usuario().get(usuarioId)
		if (!usuario){
			render "Usuario not found"; return;
			throw new UsuarioNotFoundException();
		}
		
		return usuario
    }
	
	
	/* getAviso */ 
	Aviso getAviso(avisoId) {	
	
		def aviso = new Aviso().get(avisoId)
		if (!aviso){
			render "Aviso not found"; return;
			throw new AvisoException();
		}
		
		return aviso
    }
	
	
	/* getOferta */ 
	Oferta getOferta(ofertaId) {	
	
		def oferta = new Oferta().get(ofertaId)
		if (!oferta){
			render "Oferta not found"; return;
			throw new OfertaException();
		}
		
		return oferta
    }
	
	
	/* getResena */ 
	Resena getResena(resenaId) {	
	
		def resena = new Resena().get(resenaId)
		if (!resena){
			render "Resena not found"; return;
			throw new ResenaException();
		}
		
		return resena
    }
	
	
	/* errorAndRedirect */ 
	def errorAndRedirect(String message, String action) {	
	
		flash.message = message
		flash.type = "error"
		redirect (action: action)

    }
	
	
	/* successAndRedirect */ 
	def successAndRedirect(String message, String action) {	
	
		flash.message = message
		flash.type = "ok"
		redirect (action: action)

    }
	
}