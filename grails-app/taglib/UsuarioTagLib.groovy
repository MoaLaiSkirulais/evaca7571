class UsuarioTagLib {
	
	static namespace = "evaca"

	def actions = {attrs ->		
		out << render(template:"/tagLibTemplates/UsuarioTagLib")
	}


}
