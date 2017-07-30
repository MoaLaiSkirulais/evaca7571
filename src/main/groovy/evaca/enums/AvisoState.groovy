package evaca


/* AvisoState */	
public enum AvisoState {

	BORRADOR { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state == AvisoState.PUBLICADO || aviso.state == AvisoState.APROBACION ){
					throw new AvisoException(message : "No puede volver a BORRADOR")
			}
			aviso.state = AvisoState.BORRADOR
		}
	}, 
	
	APROBACION { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state != AvisoState.BORRADOR) { 
				throw new AvisoException(message : "El aviso no está en BORRADOR")
			}
		}
		
		@Override
        public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {
			if (aviso.propietario != ejecutor){
				throw new AvisoException(message: "Solo el dueño del aviso puede pedir aprobacion")
			}
        }
		
	}, 
	
	RECHAZADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state != AvisoState.APROBACION){
				throw new AvisoException(message : "El aviso no está en APROBACION")
			}			
		}
		
		@Override
        public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {		

			if (aviso.state == AvisoState.APROBACION){
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					throw new AvisoException(message: "Se necesita un administrador para ejecutar esta accion")
				}
			}
        }
	}, 
	
	PUBLICADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
		
			/* está publicado? */
			if (aviso.state == AvisoState.PUBLICADO){
				println "El aviso ya está PUBLICADO"
				throw new AvisoException(message : "El aviso ya está PUBLICADO")
			}				
		
			/* está aprobado? */
			if (aviso.state != AvisoState.APROBACION){
				throw new AvisoException(message : "El aviso no está en APROBACION")
			}

		}
		
		@Override
        public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {
			if (aviso.state == AvisoState.APROBACION){
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					throw new AvisoException(message: "Se necesita un administrador para ejecutar esta accion")
				}
			}
        }
	}, 

	VENDIDO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state != AvisoState.PUBLICADO){
				throw new AvisoException(message : "El aviso no esta PUBLICADO")
			}
			aviso.state = AvisoState.VENDIDO
		}
	}, 
	
	CANCELADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state == AvisoState.CANCELADO){
				throw new AvisoException(message : "El aviso ya esta CANCELADO")
			}
		}
		
		@Override
        public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {		

			if (aviso.propietario != ejecutor){
				throw new AvisoException(message: "Solo el dueño del aviso puede cancelar")
			}
        }
	}
	
	/* validateStateAccess hay que ejecutarlo como super? */
	public AvisoState validateStateFlow(Aviso aviso) {
		return true
	}
	
	
	/* validateStateAccess */
	public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {		
		return true
	}	


}


 
 