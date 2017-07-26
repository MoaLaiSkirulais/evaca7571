package evaca
 
/* UsuarioState */	
public enum UsuarioState { 
	
	APROBACION { 
		public UsuarioState validateStateFlow(Usuario usuario) {		
			throw new UsuarioStateFlowException(message : "No se puede pasar manualmente a Aprobacion")
		}
	}, 

	ACTIVO { 
		public UsuarioState validateStateFlow(Usuario usuario) {
			if (usuario.state != UsuarioState.APROBACION && usuario.state != UsuarioState.INACTIVO){
				throw new UsuarioStateFlowException(message : "No se puede pasar a Activo")
			}
			return UsuarioState.ACTIVO
			
		}

		@Override
        public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		
			if (usuario.state == UsuarioState.APROBACION){
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					throw new UsuarioStateFlowException(message: "Se necesita un administrador para ejecutar esta accion")
				}
			}
        }
		
	},
	
	INACTIVO { 
		public UsuarioState validateStateFlow(Usuario usuario) {
			
			if (usuario.state != UsuarioState.ACTIVO){
				throw new UsuarioStateFlowException(message : "El usuario no está Activo")
			}
			return UsuarioState.INACTIVO
		}
		
		@Override
        public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		
			if (usuario.state == UsuarioState.APROBACION){
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					throw new UsuarioStateFlowException(message: "Se necesita un administrador para ejecutar esta accion")
				}
			}
        }
	}

	/* validateStateAccess */
	public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		return this
	}
	
}


