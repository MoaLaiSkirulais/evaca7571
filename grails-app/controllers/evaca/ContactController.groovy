package evaca

class ContactController {
	
	/* index */
	def index() {
	
		render(view: 'index', 
			model: [
				
			]
		)
    }
	
	/* send */
	def send() {	
		render "<h1>" + params + "</h1>"
    }

	/* about */
	def about() {
    }

}
