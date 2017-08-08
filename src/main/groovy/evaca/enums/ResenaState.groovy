package evaca


/* ResenaState */	
public enum ResenaState {

	BORRADOR { 
		public ResenaState validateStateFlow(Resena resena) {
			if (resena.state == ResenaState.APROBADO || resena.state == ResenaState.POSTULADO ){
				throw new ResenaException(message : "No puede volver a BORRADOR")
			}
		}
	}, 
	
	POSTULADO {
		public ResenaState validateStateFlow(Resena resena) {
			if (resena.state != ResenaState.BORRADOR) { 
				throw new ResenaException(message : "La resena no está en BORRADOR")
			}
		}

		@Override
        public ResenaState validateStateAccess(Resena resena, Usuario ejecutor) {
			// if (resena.propietario != ejecutor){
				// throw new ResenaException(message: "Solo el dueño del resena puede pedir aprobacion")
			// }
        }
		
	}, 
	
	DESAPROBADO { 
		public ResenaState validateStateFlow(Resena resena) {
			if (resena.state != ResenaState.POSTULADO){
				throw new ResenaException(message : "La resena no está en POSTULADO")
			}			
		}
		
		@Override
        public ResenaState validateStateAccess(Resena resena, Usuario ejecutor) {		
			if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
				throw new ResenaException(message: "Se necesita un administrador para ejecutar esta accion")
			}			
        }
	}, 
	
	APROBADO { 
		public ResenaState validateStateFlow(Resena resena) {
		
			/* está aprobado? */
			if (resena.state == ResenaState.APROBADO){
				throw new ResenaException(message : "La reseña ya está aprobada")
			}				
		
			/* está postulado? */
			if (resena.state != ResenaState.POSTULADO){
				throw new ResenaException(message : "La reseña no está postulada")
			}

		}
		
		@Override
        public ResenaState validateStateAccess(Resena resena, Usuario ejecutor) {

			if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
				throw new ResenaException(message: "Se necesita un administrador para ejecutar esta accion")
			}

        }
	}


	/* validateStateAccess hay que ejecutarlo como super? */
	public ResenaState validateStateFlow(Resena resena) {
		return true
	}
	
	
	/* validateStateAccess */
	public ResenaState validateStateAccess(Resena resena, Usuario ejecutor) {		
		return true
	}	


}


 
 