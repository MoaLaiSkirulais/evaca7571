package evaca


/* Aviso */	
class Aviso {

	Date fechaCreacion	
	Float precio
	Plazo plazo
	AvisoState state
	Usuario propietario
	Usuario consignatario
	Lote lote     
	Venta venta
 
	static belongsTo = [
		lote:Lote, 
		propietario:Usuario, 
		consignatario:Usuario
	]	

	static hasMany = [
		ofertas: Oferta, 
		resenas: Resena
	]
	
	static hasOne = [
		venta: Venta
	]


	/* constraints */
	static constraints = {

		state nullable: false
		consignatario nullable: true
		propietario nullable: true
		lote nullable: false
		precio nullable: true
		plazo nullable: true
		venta nullable: true

	}
	

	static mapping = {
		// state lazy: false
		// ofertas lazy: false
		// ofertas fetch: 'join'
    }
	
	
	/* Aviso() */
	public Aviso() {
		this.fechaCreacion = new Date();
		this.state = AvisoState.BORRADOR;		
	}

	
	/**
	 * aviso
	 */

	/* aprobar */
	public aprobar(Usuario ejecutor){
		
		/* está aprobado? */
		if (this.state == AvisoState.APROBADO){
			throw new AvisoException(message : "El aviso ya está APROBADO")
		}
		
		/* está postulado? */
		if (this.state != AvisoState.POSTULADO){
			throw new AvisoException(message : "El aviso no está POSTULADO")
		}
		
		/* admin */
		if (ejecutor?.profile != UsuarioProfile.ADMINISTRADOR){
			throw new AvisoException(message: "Se necesita un administrador para ejecutar esta accion")
		}
		
		/* aprueba dueño? */
		if (ejecutor == this.propietario){
			throw new AvisoException(message: "No puede aprobar su propio aviso")
		}

		this.state = AvisoState.APROBADO
	}


	/* cancelar */
	public cancelar(Usuario ejecutor){
		
		/* dueño? */
		if (ejecutor != this.propietario){
			throw new AvisoException(message: "Solo cancela el dueño del aviso")
		}

		this.state = AvisoState.CANCELADO
	}


	/* postular */
	public postular(Usuario ejecutor){
		
		// if (this.propietario != ejecutor){
			// throw new AvisoException(message: "Solo el dueño del aviso puede pedir aprobacion")
		// }
		
		if (this.state != AvisoState.BORRADOR && this.state != AvisoState.CANCELADO) { 
			throw new AvisoException(message : "El aviso no está en BORRADOR")
		}

		/* precio */
		if (!this.precio) { 
			throw new AvisoException(message : "Debe indicar un precio")
		}	
		
		/* plazo */
		if (!this.plazo) { 
			throw new AvisoException(message : "Debe indicar un plazo")
		}
		
		this.state = AvisoState.POSTULADO
	}


	/**
	 * ofertas 
	 */
	 
	/* postularOferta */
	public postularOferta(Oferta oferta, Usuario ofertante){
	

		/* solo estado aprobado puede agregar ofertas */
		if (this.state != AvisoState.APROBADO){
			throw new AvisoException(message : "El aviso no está aprobado")
		}

		/* ofertante = vendodor? */
		if (this.propietario == ofertante){
			throw new AvisoException(message: "No puede ofertar su propio aviso")
		}
		
		/* ofertante ya ofertó? */ 
		def b = this.ofertas.find { oferta1 -> oferta1.propietario == oferta.propietario }
		if (b){
			println "Ya ofertó este aviso"
			throw new AvisoException(message: "Ya ofertó este aviso")
		}

		
		/* delega bl propia de oferta */
		oferta.postular() 

		/* agregar a aviso */
		oferta.aviso = this
		this.addToOfertas(oferta)
		return

	}


	/* desaprobarOferta */
	public desaprobarOferta(Oferta oferta, Usuario ejecutor){
	
		/* solo estado aprobado */
		if (this.state != AvisoState.APROBADO){
			throw new AvisoException(message : "El aviso no está aprobado")
		}
		
		/* pertenece al aviso?! */

		/* delega bl propia de oferta */
		oferta.desaprobar(ejecutor) 

	}


	/* aprobarOferta */
	public aprobarOferta(Oferta oferta, Usuario ejecutor){
	
		/* solo estado aprobado, sino puede ser que ya está vendido */
		if (this.state != AvisoState.APROBADO){
			throw new AvisoException(message : "El aviso no está aprobado")
		}
		
		/* pertenece al aviso?! */
		
		/* delega bl propia de oferta */
		oferta.aprobar(ejecutor) 

	}


	/* aceptarOferta */
	public aceptarOferta(Oferta oferta, Usuario ejecutor){
	
		/* solo estado aprobado */
		if (this.state != AvisoState.APROBADO){
			throw new AvisoException(message : "El aviso no está aprobado")
		}
		
		/* pertenece al aviso?! */
		
		/* delega bl propia de oferta */
		oferta.aceptar(ejecutor) 
		
		/* genera la venta */
		this.venta = new Venta()
		// venta.oferta = oferta
		venta.aviso = this
		// this.venta = venta
		// this.addToVenta(venta)

		/* cambia estado */
		this.state = AvisoState.VENDIDO

	}
	
	/**
	 * resenas 
	 */
	 
	/* postularResena */
	/* al final creoque todo esto podría pasar a la class Resena! */	
	// public postularResena(Resena resena, Usuario postulante){
	public postularResena(Resena resena){
	
		/* solo estado aprobado puede agregar ofertas */
		if (this.state != AvisoState.VENDIDO){
			throw new AvisoException(message : "El aviso no está vendido")
		}

		/* postulante = vendedor || consignatario || comprador ? */
		// println resena.propietario
		if (this.propietario != resena.propietario 
				&& this.consignatario != resena.propietario){
			throw new AvisoException(message: "Solo el consignatario o el vendedor puede postular una reseña")
		}
	 
	 
		/* usuario ya reseñó? */ 
		def toFind = this.resenas.find { resena1 -> resena1.propietario == resena.propietario }
		if (toFind){
			println "Ya reseñó este aviso"
			throw new AvisoException(message: "Ya reseñó este aviso")
		}
		
		/* delega bl propia de oferta */
		resena.postular() 

		/* agregar a aviso */
		resena.aviso = this
		this.addToResenas(resena)

	}
	
	
	/* aprobarResena */
	public aprobarResena(Resena resena, Usuario ejecutor){
	
		/* solo estado aprobado puede agregar ofertas */
		if (this.state != AvisoState.VENDIDO){
			throw new AvisoException(message : "El aviso no está vendido")
		} 
		
		/* pertenece al aviso?! */
		
		/* delega bl propia de oferta */
		resena.aprobar(ejecutor) 

	}


	/* toString */
	String toString(){
		// this.id + "| owner:" + this.lote.propietario + "| consignatario: " +  this.consignatario + " | " + this.state 
		this.id + "| owner:" + this.propietario + "| consignatario: " +  this.consignatario + " | " + this.state 
	}


}
