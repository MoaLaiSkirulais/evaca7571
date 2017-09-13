package evaca

/* LoteState */	
public enum LoteState {
	
	BORRADOR { 
		public LoteState validateStateFlow(Usuario usuario) {
			throw new LoteException(message : "No se puede pasar manualmente a borrador")
		}
	}, 	

	DISPONIBLE { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state == LoteState.VENDIDO){
				throw new LoteException(message : "El lote ya fue Vendido")
			}
		}
	}, 
	
	PUBLICADO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state != LoteState.DISPONIBLE){
				throw new LoteException(message : "El lote no está Disponible")
			}
		}
	}, 

	VENDIDO { 
		public LoteState validateStateFlow(Lote lote) {
			if (lote.state != LoteState.PUBLICADO){
				throw new LoteException(message : "El lote no está Publicado")
			}
		}

	}

}


