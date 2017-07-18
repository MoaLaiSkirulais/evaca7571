package evaca

/* OfertaState */	
public enum OfertaState {
	
	BORRADOR { 
		public OfertaState validateStateFlow(Oferta oferta) {
			throw new DomainException(message : "No se puede pasar manualmente a Borrador")
		}
	}, 

	PUBLICADO { 
		public OfertaState validateStateFlow(Oferta oferta) {

			if (oferta.tbState == OfertaState.BORRADOR){
				return OfertaState.APROBACION
			}

			if (oferta.tbState == OfertaState.APROBACION){
				return OfertaState.PUBLICADO
			}

			throw new DomainException(message : "No puede pasar a Publicado")
		}

		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (oferta.tbState == OfertaState.BORRADOR){
				if (ejecutor == oferta.aviso.lote.usuario){
					throw new DomainException(message: "No puede ofertar su aviso")
				}

				if (ejecutor == oferta.aviso.consignatario){
					throw new DomainException(message: "No puede ofertar el consignatario")
				}
			}
			
			if (oferta.tbState == OfertaState.APROBACION){
				if (ejecutor.tbTipo != 'Administrador'){
					throw new DomainException(message: "You must be Admin")
				}
			}
        }
	}, 

	APROBACION{ 
		public OfertaState validateStateFlow(Oferta oferta) {
			throw new DomainException(message : "No se puede pasar manualmente a Aprobacion")
		}		
		
	}, 

	RECHAZADO { 
		public OfertaState validateStateFlow(Oferta oferta) {
			if (oferta.tbState != OfertaState.APROBACION){
				throw new DomainException(message : "Oferta debe estar en Aprobacion")
			}
			return OfertaState.BORRADOR
		}
	}, 

	CANCELADO { 
		public OfertaState validateStateFlow(Oferta oferta) {
			return OfertaState.CANCELADO
		}
	}
	
	/* validateStateAccess */
	public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {
		// if (ejecutor == 'Administrador'){
			// throw new DomainException(message: "You must be Admin")
		// }
		return this
	}


}


