package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	
	static belongsTo = [aviso:Aviso, usuario:Usuario]
	
	public Oferta() {
		this.fechaCreacion = new Date();
	}

    static constraints = {
    }
}
