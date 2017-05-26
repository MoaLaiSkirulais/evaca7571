class HeaderTagLib {
	
	static namespace = "evaca"

	def breadcrums = {attrs ->		
		out << render(template:"/tagLibTemplates/BreadCrumTagLib")
	}


}
