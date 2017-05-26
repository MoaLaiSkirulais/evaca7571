package evaca

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RazaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    // def index(Integer max) {
        // params.max = Math.min(max ?: 10, 100)
        // respond Raza.list(params), model:[razaCount: Raza.count()]
    // }

    def show(Raza raza) {
        respond raza
    }

    def create() {
        respond new Raza(params)
    }
	
	/* edit */
	def edit(Raza raza) {
        respond raza
    }

	/* index */
	def index() {
	
		def razas = Raza.list()

		render(view: 'index', 
			model: [
				razas:razas
			]
		)
    }
}
