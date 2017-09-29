package evaca

class HomeController {

    def index() {
	
		// def avisos = Aviso.list()
		
		println "caca"
		
		def avisos = Aviso.createCriteria().list () {			
			eq ("state", AvisoState.APROBADO)
		}

		render(view: 'index', 
			model: [
				avisos:avisos.reverse()
			]
		)
        
    }


}
