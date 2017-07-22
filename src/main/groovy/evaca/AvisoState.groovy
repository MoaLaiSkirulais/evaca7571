package evaca


/* AvisoState */	
public enum AvisoState {

	BORRADOR { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state == AvisoState.PUBLICADO || aviso.state == AvisoState.APROBACION ){
					throw new DomainException(message : "No puede volver a BORRADOR")
			}
			aviso.state = AvisoState.BORRADOR
		}
	}, 
	
	APROBACION { 
		public AvisoState validateStateFlow(Aviso aviso) {
			throw new DomainException(message : "No puede pasarse a APROBACION manualmente")
		}
	}, 
	
	RECHAZADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state != AvisoState.APROBACION){
				throw new DomainException(message : "El aviso no está en APROBACION")
			}
			aviso.state = AvisoState.BORRADOR
		}
	}, 
	
	PUBLICADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
		
			/* en borrador? */
			if (aviso.state == AvisoState.BORRADOR){
				aviso.state = AvisoState.APROBACION
				return;
			}
			
			/* está aprobado? */
			if (aviso.state != AvisoState.APROBACION){
				throw new DomainException(message : "El aviso no está en APROBACION")
			}				

			/* lote disponible? */
			if (aviso.lote.state != LoteState.DISPONIBLE){
				throw new DomainException(message : "Lote no disponible")
			}

			/* publíquese */
			// aviso.lote.state = LoteState.OCUPADO //esto puede delegarse
			aviso.lote.changeState(LoteState.PUBLICADO)
			aviso.state = AvisoState.PUBLICADO
		}
	}, 
	
	VENDIDO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state != AvisoState.PUBLICADO){
				throw new DomainException(message : "El aviso no esta PUBLICADO")
			}
			aviso.state = AvisoState.VENDIDO
		}
	}, 
	
	CANCELADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			aviso.state = AvisoState.CANCELADO
		}
	}
	
	/* validateStateAccess hay que ejecutarlo como super? */
	public AvisoState validateStateFlow(Aviso aviso) {

		if (this.state == AvisoState.VENDIDO){
			throw new DomainException(message : "No puede cambiar un aviso VENDIDO")
		}

		if (this.state == AvisoState.CANCELADO){
			throw new DomainException(message : "No puede cambiar un aviso CANCELADO")
		}
	}
	
	
	/* validateStateAccess */
	public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {		
		return this
	}	


}


 
 