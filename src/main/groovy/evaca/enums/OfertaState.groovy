package evaca

/* OfertaState */	
public enum OfertaState {
	
	BORRADOR { 
		public OfertaState validateStateFlow(Oferta oferta) {
			throw new OfertaStateFlowException(message : "No se puede pasar manualmente a borrador")
		}
	}, 	

	POSTULADO { //
		public OfertaState validateStateFlow(Oferta oferta) {
			if (oferta.state != OfertaState.BORRADOR) { 
				throw new OfertaException(message : "La oferta debe estar en borrador")
			}
		}
		
		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {
			if (oferta.propietario != ejecutor){
				// throw new AvisoException(message: "Solo el dueño de la oferta puede pedir aprobacion")
			}
        }

	}, 
	
	APROBADO { // 
		public OfertaState validateStateFlow(Oferta oferta) {

			/* está publicado? */
			if (oferta.state == OfertaState.APROBADO){
				throw new OfertaException(message : "La oferta ya está aprobada")
			}

			/* está aprobacion? */
			if (oferta.state != OfertaState.POSTULADO){
				throw new OfertaException(message : "La oferta no está postulada")
			}
		}

		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (ejecutor.profile != UsuarioProfile.ADMINISTRADOR){
				throw new OfertaStateFlowException(message: "Sólo un administrador puede aprobar la oferta")
			}
		
			// if (oferta.state == OfertaState.BORRADOR){

				// if (ejecutor == oferta.aviso.lote.usuario){
					// throw new OfertaStateFlowException(message: "No puede ofertar su propio aviso")
				// }

				// if (ejecutor == oferta.aviso.consignatario){
					// throw new OfertaStateFlowException(message: "No puede ofertar el consignatario")
				// }
			// }
			
			// if (oferta.state == OfertaState.APROBACION){
				// if (ejecutor.profile != 'Administrador'){
					// throw new OfertaStateFlowException(message: "You must be Admin")
				// }
			// }
        }
	}, 
	
	DESAPROBADO { //
		public OfertaState validateStateFlow(Oferta oferta) {
			if (oferta.state != OfertaState.POSTULADO){
				throw new OfertaStateFlowException(message : "La oferta debe estar en aprobacion")
			}
		}

		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {			
			if (ejecutor.profile != UsuarioProfile.ADMINISTRADOR){
				throw new OfertaStateFlowException(message: "Sólo un administrador puede desaprobar la oferta")
			}			
        }
	}, 

	ACEPTADO { //
		public OfertaState validateStateFlow(Oferta oferta) {
			
			if (oferta.state != OfertaState.APROBADO){
				throw new OfertaStateFlowException(message : "La oferta debe estar aprobada")
			}
		}
		
		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (ejecutor != oferta.aviso.lote.usuario){
				throw new OfertaStateFlowException(message: "Sólo el anunciante puede aceptar la oferta")
			}			
        }
	}, 
	
	RECHAZADO { //
		public OfertaState validateStateFlow(Oferta oferta) {
			
			if (oferta.state != OfertaState.APROBADO){
				throw new OfertaStateFlowException(message : "La oferta debe estar aprobada")
			}
		}
		
		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (ejecutor != oferta.aviso.lote.usuario){
				throw new OfertaStateFlowException(message: "Sólo el anunciante puede rechazar la oferta")
			}			
        }
	}, 

	CANCELADO { //
		public OfertaState validateStateFlow(Oferta oferta) {		
			if (oferta.state == OfertaState.CANCELADO){
				throw new OfertaStateFlowException(message : "La oferta ya se encuentra cancelada")
			}
		}
		
		@Override
        public OfertaState validateStateAccess(Oferta oferta, Usuario ejecutor) {		
		
			if (ejecutor != oferta.aviso.lote.usuario){
				throw new OfertaStateFlowException(message: "Sólo el ofertante puede cancelar la oferta")
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


