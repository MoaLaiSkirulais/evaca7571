class SessionTagLib {
	
	static namespace = "evaca"
	def sessionService
	def persona = "jajaja"
	
	def sayHi = {attrs ->
		// out << "Hello ${attrs.to}"
		out << sessionService.username
		out << sessionService.fechaCreacion
	}

	def sayHo = {attrs ->		
		out << render(template:"/tagLibTemplates/SessionTagLib", model:[sessionService:sessionService])
	}


}
