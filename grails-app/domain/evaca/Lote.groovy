package evaca

class Lote {
	
	Date fechaCreacion
	Usuario usuario
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

	static belongsTo = [
		raza: Raza, 
		categoria: Categoria, 
		usuario:Usuario
	]

	static hasMany = [avisos: Aviso]
	
	
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
    }

	
	/* Lote */
	public Lote() {
		this.fechaCreacion = new Date();
		this.state = LoteState.DISPONIBLE;
    }


	/* changeState */
	public changeState(LoteState state){
		state.validateStateFlow(this);
		this.state = state
	}


	/* toString */
	String toString(){
		// this.id + " | " + this.usuario + " | " + this.raza + " | " + this.categoria + " | " + this.cantidad
		this.id + " | " + this.usuario + " | " + this.raza + " | " + this.state
	}

}
