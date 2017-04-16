package evaca

class Usuario {

	Date fechaCreacion
	String nombre
	String apellido
	String email
	String username
	String tbTipo
	String password
	String tbState
	Float puntaje
	Float comision
	
	static hasMany = [ofertas: Oferta, resenas: Resena]
		
    static constraints = {
	
		puntaje blank: true, nullable: true, editable: false, defaultValue: 0
		email email: true, unique: true
		username size: 6..15, blank: false, unique: true
		
		// raza size: 5..15, blank: true //, unique: true
		// comision range: 0..50
		// apellido widget: 'textarea'
		
		tbState inList: ['Activo', 'Inactivo', 'Pendiente']
		tbTipo inList: ['Consignatario', 'Productor']
    }
	
    static mapping = {
        sort "fechaCreacion"
    }

}
