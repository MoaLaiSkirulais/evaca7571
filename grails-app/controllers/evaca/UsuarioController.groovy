package evaca

class UsuarioController {

	static scaffold = Usuario
	
	def register() {

		ArrayList<Book> books = new ArrayList<Book>();
		Book joe = new Book("Stephen King", "Joe"); 
		books.add(joe);
		Book steve = new Book("Steve", "Steve");
		books.add(steve);            
		

		def usuario = new Usuario(params)
		if (usuario.validate()) {
			usuario.save()
			flash.message = "Successfully Created User"
			// redirect(uri: '/')
		} else {
			flash.message = "Error Registering User"
			// return [ user: user ]
		}
 
		// render "<h1>" + params + "</h1>"

		// render "<h1>register</h1>"
		render(view: 'index', model: [
				myBook:steve, 
				params:params, 
				// usuario: Usuario.last()])
				usuario: usuario])


        // respond([myBook:steve]) 
    }
	

}
