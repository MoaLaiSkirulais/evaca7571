class UserTagLib {
	
	static namespace = "user"

	def mySessionService
	def usuarioService

	/* links */
	def links = {attrs ->
		
		out << 
			render(
				template: "/tagLibTemplates/UserTagLib/links", 
				model:[usuario:mySessionService.usuario]
			)
	
	}

	/* accesos */
	def accesos = {attrs ->
 
		out << 
			render(
				template: "/tagLibTemplates/UserTagLib/accesos", 
				model:[usuario:mySessionService.usuario]
			)		
	}
	
	/* stars */
	def stars = {attrs ->		
		out << render(template: "/tagLibTemplates/UserTagLib/stars", model:[attrs:attrs])
	}


	/* avatar */
	def avatar = {attrs ->
		if (!attrs.size){ 
			// attrs.strsize = "style=\"width:50%\""
			attrs.size = ""
		}
		out << render(template: "/tagLibTemplates/UserTagLib/avatar", model:[attrs:attrs])
	}



 
}
