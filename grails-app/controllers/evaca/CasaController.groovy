package evaca

class CasaController {

	// static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	/* create */
	def create() {
	
	    def model = [
			casa: new Casa(params), 
			casas: Casa.list()
		]

		[model: model]
    }

	/* edit */
	def edit() {

		def id=params.id
	    def model = [
			casa: new Casa().get(id), 
			casas: Casa.list()
		]

		respond view:'create', [model:model]
    }

	/* save */
	def save(Casa casa) {
	
		if (!params.id){
			casa = new Casa(params)
		}
		
		def log = 
			"<h1>" + params + "</h1>" + 
			"<h1>" + request + "</h1>" + 
			"<h1>" + response + "</h1>" + 
			"<h1>" + session + "</h1>" + 
			"<h1>" + servletContext + "</h1>"
		// render log

		casa.save(flush:true)

		def model = [
			casa: casa, 
			casas: Casa.list()
		]

		if (casa.hasErrors()) {
			respond view:'create', [model:model]
			return
		}

		redirect action:"edit", id:casa.id
	    
    }


}
