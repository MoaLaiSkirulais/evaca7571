package evaca

class SessionController {

	static scaffold = Session
	
	def create() {
		Session s = new Session();
		s.fechaCreacion = new Date();
		s.owner = Usuario.list()[2]
        respond([session:s]) 
	}
	
	
}
