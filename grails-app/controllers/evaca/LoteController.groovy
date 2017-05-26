package evaca

class LoteController {

	// static scaffold = Lote
	
	def create() {
		Lote l = new Lote();
		l.usuario = Usuario.list()[2]
        respond([lote:l]) 
	}
	
	/* edit */
	def edit(Lote lote) {
        respond lote
    }
	
	/* show */
	def show(Lote lote) {
        respond lote
    }
	
	/* index */
	def index() {
	
		def lotes = Lote.list()

		render(view: 'index', 
			model: [
				lotes:lotes
			]
		)
    }
	
	def update() {
        // if (lote == null) {
            // notFound()
            // return
        // }

		def lote = new Lote(params)
        if (lote.hasErrors()) {
			flash.message = "errors"
            respond lote.errors, view:'edit'
            return
        }
		
		flash.message = "Heeee"
		
		lote.save()
        // lote.save flush:true
        // respond lote
		
		render(view: 'edit', model: [
				params:params, 
				lote: lote])
        
    }

}
