package evaca

/* OfertaState */	
public enum OfertaState {
	
	BORRADOR { 
		public OfertaState validateStateFlow(Oferta oferta) {
			throw new OfertaStateFlowException(message : "No se puede pasar manualmente a Borrador")
		}
	}, 

	ACEPTADO { 
		public OfertaState validateStateFlow(Oferta oferta) {
			
			if (oferta.state != OfertaState.PUBLICADO){
				throw new OfertaStateFlowException(message : "Oferta debe estar en Publicado")
			}
			return OfertaState.ACEPTADO
		}
		
		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (ejecutor != oferta.aviso.lote.usuario){
				throw new OfertaStateFlowException(message: "Solo el dueño del aviso puede aceptar la oferta")
			}			
        }
	}, 

	PUBLICADO { 
		public OfertaState validateStateFlow(Oferta oferta) {

			if (oferta.state == OfertaState.BORRADOR){
				return OfertaState.APROBACION
			}

			if (oferta.state == OfertaState.APROBACION){
				return OfertaState.PUBLICADO
			}

			throw new OfertaStateFlowException(message : "No puede pasar a Publicado")
		}

		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (oferta.state == OfertaState.BORRADOR){
				if (ejecutor == oferta.aviso.lote.usuario){
					throw new OfertaStateFlowException(message: "No puede ofertar su propio aviso")
				}

				if (ejecutor == oferta.aviso.consignatario){
					throw new OfertaStateFlowException(message: "No puede ofertar el consignatario")
				}
			}
			
			if (oferta.state == OfertaState.APROBACION){
				if (ejecutor.profile != 'Administrador'){
					throw new OfertaStateFlowException(message: "You must be Admin")
				}
			}
        }
	}, 

	APROBACION{ 
		public OfertaState validateStateFlow(Oferta oferta) {
			throw new OfertaStateFlowException(message : "No se puede pasar manualmente a Aprobacion")
		}		

	}, 

	RECHAZADO { 
		public OfertaState validateStateFlow(Oferta oferta) {
			if (oferta.state != OfertaState.APROBACION){
				throw new OfertaStateFlowException(message : "Oferta debe estar en Aprobacion")
			}
			return OfertaState.BORRADOR
		}

		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {			
			if (ejecutor.profile != 'Administrador'){
				throw new OfertaStateFlowException(message: "You must be Admin")
			}			
        }
	}, 

	CANCELADO { 
		public OfertaState validateStateFlow(Oferta oferta) {		
			if (oferta.state == OfertaState.CANCELADO){
				throw new OfertaStateFlowException(message : "Oferta ya está Cancelado")
			}

			return OfertaState.CANCELADO
		}
		
		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (ejecutor != oferta.aviso.lote.usuario){
				throw new OfertaStateFlowException(message: "Solo el dueño del aviso puede cancelar la oferta")
			}			
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


