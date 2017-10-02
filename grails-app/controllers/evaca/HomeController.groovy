package evaca

class HomeController {

    def index() {
	
		// def avisos = Aviso.list()
		
		println "caca"
		
		def avisos = Aviso.createCriteria().list () {
			eq ("state", AvisoState.APROBADO)
			
			if (params?.filter?.raza?.id) {
				lote{raza{eq("id", params.filter.raza.id.toLong())}}
			}

			if (params?.filter?.categoria?.id) {
				lote{categoria{eq("id", params.filter.categoria.id.toLong())}}
			}
			
			if (params?.filter?.propietario?.id) {
				lote{propietario{eq("id", params.filter.propietario.id.toLong())}}
			}
		}

		render(view: 'index', 
			model: [
				avisos:avisos.reverse()
			]
		)
        
    }


}
