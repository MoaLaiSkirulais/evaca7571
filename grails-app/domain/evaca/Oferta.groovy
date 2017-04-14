package evaca

class Oferta {

	Date fechaCreacion
	
	Aviso aviso
	static belongsTo = [aviso:Aviso]

    static constraints = {
    }
}
