package evaca

class LoteController {

	static scaffold = Lote
	
	def create() {
		Lote l = new Lote();
		l.usuario = Usuario.list()[2]
        respond([lote:l]) 
	}


}
