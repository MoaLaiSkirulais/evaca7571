package evaca

class Lote {
	
	Date fechaCreacion
	Usuario usuario
	Raza raza	
	Categoria categoria
	Integer cantidad
	String ubicacion
	Integer pesoPromedio
	Integer pesoMaximo
	Integer pesoMinimo
	Integer edad
	Boolean trazada
	Boolean marcaLiquida
	
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
		pesoPromedio()
		pesoMaximo()
		pesoMinimo()
		edad()
		trazada()
		marcaLiquida()

    }
	
	public Lote() {
		this.fechaCreacion = new Date();
		// this.usuario = Usuario.list()[2]
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
