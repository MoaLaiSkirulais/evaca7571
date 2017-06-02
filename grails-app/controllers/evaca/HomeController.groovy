package evaca

class HomeController {

    def index() {
	
		def avisos = Aviso.list()

		render(view: 'index', 
			model: [
				avisos:avisos
			]
		)
        
    }


}
