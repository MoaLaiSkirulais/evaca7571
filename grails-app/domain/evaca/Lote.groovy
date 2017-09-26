package evaca

class Lote {
	
	Date fechaCreacion
	Usuario propietario
	Raza raza	
	Categoria categoria

	Integer cantidad
	String ubicacion
	String provincia
	Integer pesoPromedio
	Integer pesoMaximo
	Integer pesoMinimo
	Integer edad
	Boolean trazada
	Boolean marcaLiquida
	LoteState state	
	byte[] image /* despues podria salir en 1-1 */
	Aviso aviso 

	static belongsTo = [
		raza: Raza, 
		categoria: Categoria, 
		propietario: Usuario
	]

	static hasOne = [aviso: Aviso]	
	
	/* mapping */
    static mapping = {
		image column: 'image', sqlType: 'longblob' 
    }


	/* constraints */
	static constraints = {

		cantidad nullable: true
		ubicacion nullable: true
		provincia nullable: true
		pesoPromedio nullable: true
		pesoMaximo nullable: true
		pesoMinimo nullable: true
		edad nullable: true		
		trazada nullable: true
		marcaLiquida nullable: true
		image nullable: true
		aviso nullable: true /* esto no deberia ser! */
    }

	
	/* Lote */
	public Lote() {
		this.fechaCreacion = new Date();
		// this.state = LoteState.DISPONIBLE;
		this.state = LoteState.BORRADOR;
    }


	/* changeState */
	public changeState(LoteState state){
		// state.validateStateFlow(this);
		// this.state = state
	}


	/* iniciar */
	public iniciar(){ /* uhmm */
		this.aviso = new Aviso([propietario: this.propietario])
	}


	/* toString */
	String toString(){
		// this.id + " | " + this.usuario + " | " + this.raza + " | " + this.categoria + " | " + this.cantidad
		this.id + " | " + this.propietario + " | " + this.raza + " | " + this.state
	}
	
	
	/* _postular */
	public _postular(){
	
		// return 
		/* basicamente no se toman grandes acciones */
		/* en borrador? */
		if (this.state != LoteState.BORRADOR) { 
			throw new LoteException(message : "El lote debe estar en borrador")
		}
		
		// def aviso = new Aviso()
		// aviso.lote = this
		// aviso.propietario = this.propietario
		// // this.addToAvison(aviso)
		
		this.aviso = new Aviso()
		this.aviso.lote = this /* este ida y vuelta es muy raro! */
		this.aviso.propietario = this.propietario
		this.state = LoteState.DISPONIBLE

	}

	
	/* postular */
	public postular(){ /* ojo siempre un ejecutor?! */
		
		/* solo estado aprobado puede agregar lotes */
		if (this.propietario.state != UsuarioState.APROBADO){
			throw new LoteException(message : "El usuario no está aprobado")
		}
	
		/* en borrador? */
		if (this.state != LoteState.BORRADOR) { 
			throw new LoteException(message : "El lote debe estar en borrador")
		}
		
		/* raza */
		if (!this.raza) { 
			throw new LoteException(message : "Debe indicar raza")
		}
		  
		/* categoria */
		if (!this.categoria) { 
			throw new LoteException(message : "Debe indicar categoria")
		}

		/* propietario */
		if (!this.propietario) { 		
			throw new LoteException(message : "Debe indicar propietario")
		}

		/* inicializa el aviso */
		this.aviso = new Aviso()
		this.aviso.lote = this 
		// this.aviso.propietario = this.propietario		
		// this.aviso.propietario =  Usuario.findByUsername("consignatario")
		this.aviso.propietario = Usuario.findByUsername(this.propietario.username) /* wtf con esto?¡ */		
		
		/* state inicial */
		this.state = LoteState.DISPONIBLE

	}

	
	/* actualizar */
	public actualizar(){ 
		
		/* en borrador? */
		if (this.state != LoteState.DISPONIBLE) { 
			throw new LoteException(message : "El lote debe estar disponible")
		}
		
		/* raza */
		if (!this.raza) { 
			throw new LoteException(message : "Debe indicar raza")
		}
		  
		/* categoria */
		if (!this.categoria) { 
			throw new LoteException(message : "Debe indicar categoria")
		}

		/* propietario */
		if (!this.propietario) { 		
			throw new LoteException(message : "Debe indicar propietario")
		}

	}
	
	/** 
	 * Aviso
	 */
	
	/* postularAviso */
	public postularAviso(Aviso aviso){ 	

		// /* valida lote propio */
		// if (aviso.propietario != aviso.lote?.usuario){
			// throw new AvisoException(message : "El lote no pertenece al dueño del aviso")	
		// }

		/* valida lote libre */
		if (this.state != LoteState.DISPONIBLE){
			throw new AvisoException(message : "El lote no está disponible")	
		}
		
		/* delega */
		aviso.postular()

		/* lockea lote */
		this.state = LoteState.PUBLICADO
		
	}
	 
	
	/* cancelarAviso */
	public cancelarAviso(Aviso aviso, Usuario ejecutor){

		/* delega */
		aviso.cancelar(ejecutor)

		/* lockea lote */
		this.state = LoteState.DISPONIBLE
		
	}
	 

}
