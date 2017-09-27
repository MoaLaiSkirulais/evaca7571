package evaca

class AdminTagLib {
	
	static namespace = "admin"

	def links = {attrs ->		
		out << render(template:"/tagLibTemplates/AdminTagLib/links", model:[attrs:attrs])
	}


}
