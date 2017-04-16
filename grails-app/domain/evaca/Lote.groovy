package evaca

class Lote {
	
    // static hasMany = [names: String]
	// String[] list = ["a", "n"]
	
    // List friends
    // static hasMany1 = [ friends: String ]

	Date fechaCreacion
	Integer cantidad
	Integer pesoPromedio
	Integer pesoMaximo
	Integer pesoMinimo
	Boolean trazada
	String ubicacion
	Integer edad
	// String descarte
	Boolean marcaLiquida
	// String pesada
	// String desbaste
	String cuit
	// Float precio
	Integer tiempoDePago
      
	Raza raza	
	Categoria categoria
	
	static belongsTo = [raza: Raza, categoria: Categoria, usuario:Usuario]

	static constraints = {

		// descarte blank: true, nullable: true
		// pesada blank: true, nullable: true
		// desbaste blank: true, nullable: true

		// raza size: 5..15, blank: true //, unique: true
		// categoria blank: false, nullable: false
		// categoria inList: ['A', 'B', 'C']

        // password size: 5..15, blank: false
        // email email: true, blank: false
        // age min: 18


    }
}
