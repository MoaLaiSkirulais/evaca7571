class HomeTagLib {
	
	static namespace = "evaca"

	def productBox = {attrs ->		
		out << render(template:"/tagLibTemplates/HomeTagLib/productBox", model:[attrs:attrs])
	}


}
