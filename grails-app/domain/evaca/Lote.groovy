package evaca

class Lote {
	
    // static hasMany = [names: String]
	// String[] list = ["a", "n"]
	
    // List friends
    // static hasMany1 = [ friends: String ]

	Date fechaCreacion
	Integer cantidad
	String categoria
	Integer pesoPromedio
	Integer pesoMaximo
	Integer pesoMinimo
	String trazada
	String ubicacion
	Integer edad
	String descarte
	String marcaLiquida
	String pesada
	String desbaste
	String cuit
	Float precio
	Integer tiempoDePago
      
  Raza raza      
  static belongsTo = [raza:Raza]

	
	
	static constraints = {

		// raza size: 5..15, blank: true //, unique: true
		categoria blank: false, nullable: false
		 categoria inList: ['A', 'B', 'C']

        // password size: 5..15, blank: false
        // email email: true, blank: false
        // age min: 18


    }
}
