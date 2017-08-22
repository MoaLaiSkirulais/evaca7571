package evaca

class SessionTagLib {
	
	static namespace = "evaca"
	def mySessionService

	/* sayHi */ 
	def sayHi = {attrs ->
		out << mySessionService.username
		out << mySessionService.fechaCreacion
	}

	/* showSession */ 
	def showSession = {attrs ->
		if (mySessionService.isLogged()) {			
			out << render(template:"/tagLibTemplates/SessionTagLib", model:[mySessionService:mySessionService])
		} else {
			out << "<a href=\"/usuario/newlogin\">login</a>"
		}
	}

}
