package evaca

/* LoteState */	
public enum LoteState {

	DISPONIBLE { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state == LoteState.VENDIDO){
				throw new DomainException(message : "El lote ya fue Vendido")
			}
			return LoteState.DISPONIBLE
		}
	}, 
	
	PUBLICADO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state != LoteState.DISPONIBLE){
				throw new DomainException(message : "El lote no está Disponible")
			}
			return LoteState.PUBLICADO
		}
	}, 

	VENDIDO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state != LoteState.PUBLICADO){
				throw new DomainException(message : "El lote no está Publicado")
			}
			return LoteState.VENDIDO
		}

	}

}


