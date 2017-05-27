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
		lote.save()
        if (lote.hasErrors()) {
			flash.message = "errors"
			render "<h1>" + params + "</h1>"
			render "<h1>" + lote.errors + "</h1>"
            respond lote.errors, view:'edit', id: lote.id
            return
        }
		// render "<h1>" + params + "</h1>"

		flash.message = "El registro se actualizó exitosamente"		
		render "<h1>" + lote.errors + "</h1>"
        // lote.save flush:true
        // respond lote
		redirect(controller: "lote", action: "edit", id: lote.id, namespace: "evaca")
		// render(view: 'edit', model: [
				// params:params, 
				// lote: lote])
        
    }

}
