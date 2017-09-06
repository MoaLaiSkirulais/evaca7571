package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario propietario
	Plazo plazo
	Float precio
	OfertaState state
	Venta venta 

	static belongsTo = [aviso:Aviso, propietario:Usuario, plazo:Plazo]	
	static hasOne = [venta: Venta]
    // static mappedBy = [child: 'parent']
	// static mappedBy = [venta: "oferta"]


	
	/* Oferta() */
	public Oferta() {
		this.fechaCreacion = new Date();
		this.state = OfertaState.BORRADOR;
	}	
	
	
	/* constraints */
    static constraints = {
		venta nullable: true
    }


	/* changeState */
	public changeState(OfertaState state, Usuario ejecutor){
		// state.validateStateAccess(this, ejecutor)
		// state.validateStateFlow(this)
		// this.state = state

	}
	
	
	/* postular */
	public postular(Usuario ejecutor){
		
		if (this.state != OfertaState.BORRADOR) { 
			throw new OfertaException(message : "La oferta debe estar en borrador")
		}
	
		if (this.propietario != ejecutor){
			throw new OfertaException(message: "Solo el dueño de la oferta puede pedir aprobacion")
		}        
		
		this.state = OfertaState.POSTULADO

	}
	
	/* aprobar */
	public aprobar(Usuario ejecutor){
		
		/* está publicado? */
		if (this.state == OfertaState.APROBADO){
			throw new OfertaException(message : "La oferta ya está aprobada")
		}

		/* está aprobacion? */
		if (this.state != OfertaState.POSTULADO){
			throw new OfertaException(message : "La oferta no está postulada")
		}
		
		/* admin? */
		if (ejecutor.profile != UsuarioProfile.ADMINISTRADOR){
			throw new OfertaStateFlowException(message: "Sólo un administrador puede aprobar la oferta")
		}
		
		this.state = OfertaState.APROBADO

	}

	
	/* aceptar */
	public aceptar(Usuario ejecutor){
			
		/* aprobada? */
		if (this.state != OfertaState.APROBADO){
			throw new OfertaStateFlowException(message : "La oferta debe estar aprobada")
		}
	
		/* owner? */
		if (ejecutor != this.aviso.propietario){
			throw new OfertaStateFlowException(message: "Sólo el anunciante puede aceptar la oferta")
		}			

		/* genera venta */
		this.venta = new Venta()
		// venta.oferta = oferta
		// venta.save(flush:true, failOnError: false)
		
		this.state = OfertaState.ACEPTADO

	}

	
}