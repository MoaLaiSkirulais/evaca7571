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
	String imagen
	LoteState tbState

	static belongsTo = [
		raza: Raza, 
		categoria: Categoria, 
		usuario:Usuario
	]

	static hasMany = [avisos: Aviso]


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
		imagen nullable: true

    }

	
	/* Lote */
	public Lote() {
		this.fechaCreacion = new Date();
		this.imagen = "static/sham/img/products/v0.gif"
		this.tbState = LoteState.DISPONIBLE;
    }


	/* changeState */
	public changeState(LoteState tbState){
		this.tbState = tbState.validateStateFlow(this);
	}


	/* toString */
	String toString(){
		this.id + " | " + this.usuario + " | " + this.raza + " | " + this.categoria + " | " + this.cantidad
	}

}
