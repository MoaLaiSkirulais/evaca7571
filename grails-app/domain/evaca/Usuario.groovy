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
	
	// public Usuario(Map map) {
        // map?.each { k, v -> this[k] = v }
        // nombre = "garcha"
    // }

	
	static hasMany = [ofertas: Oferta, resenas: Resena]

    static constraints = {
	
		// fechaCreacion()
		fechaCreacion blank: true, nullable: true, editable: false
		nombre()
		apellido()
		email email: true, unique: true
		tbState inList: ['Activo', 'Inactivo', 'Pendiente']
		tbTipo inList: ['Consignatario', 'Productor']
		
		username size: 6..15, blank: false, unique: true		
		password()
	
		puntaje blank: true, nullable: true, editable: false, defaultValue: 0
		comision()
		// raza size: 5..15, blank: true //, unique: true
		// comision range: 0..50
		// apellido widget: 'textarea'

    }
	
    static mapping = {
        sort "fechaCreacion"
    }
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = new Date()
    }

}
