package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	
	static belongsTo = [aviso:Aviso, usuario:Usuario]

    static constraints = {
    }
}
