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
	
	// String cuit
	// Integer tiempoDePago
    // static hasMany = [names: String]
	// String[] list = ["a", "n"]
	// String descarte
	// String pesada
	// String desbaste
	
	static belongsTo = [raza: Raza, categoria: Categoria, usuario:Usuario]
	static hasMany = [avisos: Aviso]

	static constraints = {

		fechaCreacion nullable: true
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

    }
	
	public Lote() {
		this.fechaCreacion = new Date();
		this.imagen = "static/sham/img/products/v0.gif"
    }
	
	def beforeInsert() {
		this.fechaCreacion = new Date()
		this.usuario = Usuario.list()[2]
	}
	
	def beforeUpdate() {
	}
	
    def beforeValidate() {
    }
	
	// String toString(){
		// this.fechaCreacion.toString()
	// }

}
