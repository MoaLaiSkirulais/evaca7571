class UsuarioTagLib {
	
	static namespace = "evaca"

	def actions = {attrs ->		
		out << render(template:"/tagLibTemplates/UsuarioTagLib")
	}

	def links = {attrs ->		
		out << render(template:"/tagLibTemplates/UsuarioLinksTagLib")
	}


}
