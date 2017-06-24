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

	static hasMany = [ofertas: Oferta, resenas: Resena, lotes: Lote]

    static constraints = {
	
		fechaCreacion blank: true, nullable: true
		nombre()
		apellido()
		email email: true, unique: true
		tbState nullable: true, inList: ['Activo', 'Inactivo', 'Pendiente']
		tbTipo inList: ['Consignatario', 'Productor', 'Administrador']		
		username size: 6..15, blank: false, unique: true		
		password()
		puntaje blank: true, nullable: true, editable: false, defaultValue: 0
		comision()

    }
	
    static mapping = {
        sort "fechaCreacion"
    }
	
    public Usuario() {
		this.fechaCreacion = new Date();
		this.tbState = "Pendiente";
    }
	
	// public void setFechaCreacion(Date fechaCreacion) {
		// this.fechaCreacion = new Date()
    // }
	
	def beforeInsert() {
		this.fechaCreacion = new Date()
		this.tbState = "Pendiente"
	}
	
	String toString(){
		this.nombre + " " + this.apellido
	}

}
