package evaca

import evaca.Raza
import evaca.Usuario


class BootStrap {
	
   // def populateService
   def populateProService


    def init = { servletContext ->
	

		// populateProService.all()
		// populateService.all()
		// myService.countAll()
		
		/* init */    
		return
		populateProService.all()
		
		def u = new UsuarioReader()
		u.loadFromCsv()

		def r = new LoteReader()
		r.loadFromCsv()
		
		def o = new OfertaReader()
		o.loadFromCsv()

    }
    def destroy = {
    }
}
