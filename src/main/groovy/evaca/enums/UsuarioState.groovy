package evaca
 
/* UsuarioState */	
public enum UsuarioState { 
	
	BORRADOR { 
		public UsuarioState validateStateFlow(Usuario usuario) {
			throw new UsuarioStateFlowException(message : "No se puede pasar manualmente a borrador")
		}
	}, 	
	
	POSTULADO { 
		public UsuarioState validateStateFlow(Usuario usuario) {		
			if (usuario.state != UsuarioState.BORRADOR) { 
				throw new UsuarioStateFlowException(message : "El usuario no está en BORRADOR")
			}
		}
	}, 

	APROBADO { 
		public UsuarioState validateStateFlow(Usuario usuario) {
			
			/* ya está aprobado? */
			if (usuario.state == UsuarioState.APROBADO){
				throw new UsuarioStateFlowException(message : "El usuario ya está aprobado")
			}

			/* está aprobacion? */
			if (usuario.state != UsuarioState.POSTULADO){
				throw new UsuarioStateFlowException(message : "El usuario no está postulado")
			}
			
		}

		@Override
        public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		
			if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
				throw new UsuarioStateFlowException(message: "Se necesita un administrador para ejecutar esta accion")
			}

        }
		
	},
	
	DESAPROBADO { 
		public UsuarioState validateStateFlow(Usuario usuario) {
		
			if (usuario.state != UsuarioState.DESAPROBADO){
				throw new UsuarioStateFlowException(message : "El usuario ya está desaprobado")
			}
		}
		
		@Override
        public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		

			if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
				throw new UsuarioStateFlowException(message: "Se necesita un administrador para ejecutar esta accion")
			}

        }
	}

	/* validateStateAccess */
	public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		return this
	}
	
}


