package evaca

import evaca.Raza
import evaca.Usuario


class BootStrap {
	
   // def populateService
   def populateProService
   def populateXProService


    def init = { servletContext ->

		/* init */    
		populateXProService.usuarios()
		populateXProService.razas()
		populateXProService.categorias()
		populateXProService.plazos()
		populateXProService.preguntas()
		
		def u = new UsuarioReader()
		u.loadFromCsv()

		def r = new LoteReader()
		r.loadFromCsv()
		// return
		def o = new OfertaReader()
		o.loadFromCsv()

		def re = new ResenaReader()
		re.loadFromCsv()

    }
    def destroy = {
    }
}
