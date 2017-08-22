class AdminTagLib {
	
	static namespace = "admin"
	
	def mySessionService

	def links = {attrs ->
		
		if (mySessionService.isAdministrator()){
			out << render(template:"/tagLibTemplates/AdminTagLib/links")
		}
	}


}
