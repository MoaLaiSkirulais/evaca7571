package evaca

class PlazoController extends BaseController {
	
	def plazoService

	/* create */
	def create() {
		plazoService.create()
    }
	


	/* edit */
	def edit() {	
		respond view:'create', plazoService.edit(params.id)
    }

	

	/* index */
	def index() {
		render(view: 'index', model:plazoService.search())
    }
	


	/* save */
	def save(Plazo plazo) {
		plazoService.save(plazo)
		redirect action:"edit", id:plazo.id
	}	

}
