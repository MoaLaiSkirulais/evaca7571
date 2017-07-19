package evaca
 
/* UsuarioState */	
public enum UsuarioState { 
	
	APROBACION { 
		public UsuarioState validateStateFlow(Usuario usuario) {		
			throw new DomainException(message : "No se puede pasar manualmente a Aprobacion")
		}
	}, 

	ACTIVO { 
		public UsuarioState validateStateFlow(Usuario usuario) {
			if (usuario.state == UsuarioState.APROBACION){
				return UsuarioState.ACTIVO
			}
		}

		@Override
        public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		
			if (usuario.state == UsuarioState.APROBACION){
				println "---" + ejecutor 
				println "---" + ejecutor?.profile
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					println "!"
					throw new DomainException(message: "You must be Admin")
				}
			}
        }
		
	},
	
	INACTIVO { 
		public UsuarioState validateStateFlow(Usuario usuario) {
			
			if (usuario.state != UsuarioState.ACTIVO){
				throw new DomainException(message : "El usuario no está Activo")
			}
			return UsuarioState.INACTIVO
		}
		
		@Override
        public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		
			if (usuario.state == UsuarioState.APROBACION){
				if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
					throw new DomainException(message: "You must be Admin")
				}
			}
        }
	}

	/* validateStateAccess */
	public UsuarioState validateStateAccess(Usuario usuario, Usuario ejecutor) {		
		return this
	}
	
}


