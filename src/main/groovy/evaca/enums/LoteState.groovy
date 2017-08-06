package evaca

/* LoteState */	
public enum LoteState {

	DISPONIBLE { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state == LoteState.VENDIDO){
				throw new DomainException(message : "El lote ya fue Vendido")
			}
		}
	}, 
	
	PUBLICADO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state != LoteState.DISPONIBLE){
				throw new DomainException(message : "El lote no está Disponible")
			}
		}
	}, 

	VENDIDO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state != LoteState.PUBLICADO){
				throw new DomainException(message : "El lote no está Publicado")
			}
		}

	}

}


