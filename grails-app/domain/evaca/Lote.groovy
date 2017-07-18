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

	static belongsTo = [raza: Raza, categoria: Categoria, usuario:Usuario]
	static hasMany = [avisos: Aviso]

	
	/* constraints */
	static constraints = {

		fechaCreacion nullable: false
		usuario nullable: true
		raza()	
		categoria()
		cantidad()
		ubicacion()
		provincia nullable: true
		pesoPromedio()
		pesoMaximo()
		pesoMinimo()
		edad()
		trazada nullable: true
		marcaLiquida nullable: true
		imagen nullable: true
		// tbState nullable: false, inList: ['Borrador', 'Publicado', 'Vendido']

    }

	
	/* Lote */
	public Lote() {
		this.fechaCreacion = new Date();
		this.imagen = "static/sham/img/products/v0.gif"
		this.tbState = LoteState.DISPONIBLE;
    }


	/* changeState */
	public changeState(LoteState tbState){

		/* state flow */		
		println "setTbState: " + tbState
		println "this.setTbState: " + this.tbState

		this.tbState = tbState.validateStateFlow(this);

	}


	/* beforeInsert */
	def beforeInsert() {
		// this.fechaCreacion = new Date()
	}

	
	/* toString */
	String toString(){
		this.id + " | " + this.usuario + " | " + this.raza + " | " + this.categoria + " | " + this.cantidad
	}

}
