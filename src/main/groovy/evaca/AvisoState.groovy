package evaca


/* AvisoState */	
public enum AvisoState {

	BORRADOR { 
		public void validateStateFlow(Aviso aviso) {
			if (aviso.tbState == AvisoState.PUBLICADO || aviso.tbState == AvisoState.APROBACION ){
					throw new DomainException(message : "No puede volver a BORRADOR")
			}
			aviso.tbState = AvisoState.BORRADOR
		}
	}, 
	
	APROBACION { 
		public void validateStateFlow(Aviso aviso) {
			throw new DomainException(message : "No puede pasarse a APROBACION manualmente")
		}
	}, 
	
	RECHAZADO { 
		public void validateStateFlow(Aviso aviso) {
			if (aviso.tbState != AvisoState.APROBACION){
				throw new DomainException(message : "El aviso no está en APROBACION")
			}
			aviso.tbState = AvisoState.BORRADOR
		}
	}, 
	
	PUBLICADO { 
		public void validateStateFlow(Aviso aviso) {
		
			/* en borrador? */
			if (aviso.tbState == AvisoState.BORRADOR){
				aviso.tbState = AvisoState.APROBACION
				return;
			}
			
			/* está aprobado? */
			if (aviso.tbState != AvisoState.APROBACION){
				throw new DomainException(message : "El aviso no está en APROBACION")
			}				

			/* lote disponible? */
			if (aviso.lote.tbState != LoteState.DISPONIBLE){
				throw new DomainException(message : "Lote no disponible")
			}

			/* publíquese */
			// aviso.lote.tbState = LoteState.OCUPADO //esto puede delegarse
			aviso.lote.changeState(LoteState.PUBLICADO)
			aviso.tbState = AvisoState.PUBLICADO
		}
	}, 
	
	VENDIDO { 
		public void validateStateFlow(Aviso aviso) {
			if (aviso.tbState != AvisoState.PUBLICADO){
				throw new DomainException(message : "El aviso no esta PUBLICADO")
			}
			aviso.tbState = AvisoState.VENDIDO
		}
	}, 
	
	CANCELADO { 
		public void validateStateFlow(Aviso aviso) {
			aviso.tbState = AvisoState.CANCELADO
		}
	}
	


}


 