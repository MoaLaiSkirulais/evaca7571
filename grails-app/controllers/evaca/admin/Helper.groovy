package evaca

trait Helper {
	
	
	/* pija */ 
	def pija() {	
	
		render "pija"
		return

    }
	
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