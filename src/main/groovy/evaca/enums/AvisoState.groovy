package evaca


/* AvisoState */	
public enum AvisoState {

	BORRADOR { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state == AvisoState.APROBADO || aviso.state == AvisoState.POSTULADO ){
				throw new AvisoException(message : "No puede volver a BORRADOR")
			}
		}
	}, 
	
	POSTULADO { 
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
			if (aviso.state != AvisoState.POSTULADO){
				throw new AvisoException(message : "El aviso no está en POSTULADO")
			}			
		}
		
		@Override
        public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {		
			if (aviso.state == AvisoState.POSTULADO){
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					throw new AvisoException(message: "Se necesita un administrador para ejecutar esta accion")
				}
			}
        }
	}, 
	
	APROBADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
		
			/* está aprobado? */
			if (aviso.state == AvisoState.APROBADO){
				throw new AvisoException(message : "El aviso ya está APROBADO")
			}				
		
			/* está postulado? */
			if (aviso.state != AvisoState.POSTULADO){
				throw new AvisoException(message : "El aviso no está POSTULADO")
			}

		}
		
		@Override
        public AvisoState validateStateAccess(Aviso aviso, Usuario ejecutor) {

			if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
				throw new AvisoException(message: "Se necesita un administrador para ejecutar esta accion")
			}

        }
	}, 

	VENDIDO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			if (aviso.state != AvisoState.APROBADO){
				throw new AvisoException(message : "El aviso no esta APROBADO")
			}
			aviso.state = AvisoState.VENDIDO
		}
	}, 
	
	CANCELADO { 
		public AvisoState validateStateFlow(Aviso aviso) {
			
			if (aviso.state == AvisoState.CANCELADO){
				println "bien!"
				throw new AvisoException(message : "El aviso ya está CANCELADO")
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


 
 