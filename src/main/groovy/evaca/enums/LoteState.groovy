package evaca

/* LoteState */	
public enum LoteState {

	DISPONIBLE { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.tbState == LoteState.VENDIDO){
				throw new DomainException(message : "El lote ya fue Vendido")
			}
			return LoteState.DISPONIBLE
		}
	}, 
	
	PUBLICADO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.tbState != LoteState.DISPONIBLE){
				throw new DomainException(message : "El lote no está Disponible")
			}
			return LoteState.PUBLICADO
		}
	}, 

	VENDIDO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.tbState != LoteState.PUBLICADO){
				throw new DomainException(message : "El lote no está Publicado")
			}
			return LoteState.VENDIDO
		}

	}

}


