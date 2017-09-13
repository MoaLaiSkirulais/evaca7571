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
	
	
	/* postular */
	public postular(){
	
		// return 
		/* basicamente no se toman grandes acciones */
		/* en borrador? */
		if (this.state != LoteState.BORRADOR) { 
			throw new LoteException(message : "El lote debe estar en borrador")
		}
		
		println this.propietario
		this.aviso = new Aviso()
		this.aviso.lote = this /* este ida y vuelta es muy raro! */
		this.aviso.propietario = this.propietario
		this.state = LoteState.DISPONIBLE

	}

}
