class SessionTagLib {
	
	static namespace = "evaca"
	def sessionService
	def persona = "jajaja"

	def sayHi = {attrs ->
		out << sessionService.username
		out << sessionService.fechaCreacion
	}

	def showSession = {attrs ->
	 
		if (sessionService.isLogged()) {			
			out << render(template:"/tagLibTemplates/SessionTagLib", model:[sessionService:sessionService])
		} else {
			out << "<a href=\"/usuario/login\">login</a>"
		}
	}


}
