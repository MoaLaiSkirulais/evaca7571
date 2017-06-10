package evaca

class Oferta {

	Date fechaCreacion	
	Aviso aviso
	Usuario usuario
	Plazo plazo
	Float precio

	static belongsTo = [aviso:Aviso, usuario:Usuario, plazo:Plazo]
	
	public Oferta() {
		this.fechaCreacion = new Date();
	}

    static constraints = {
    }
}
