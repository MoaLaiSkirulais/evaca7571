class HeaderTagLib {
	
	static namespace = "evaca"

	def breadcrums = {attrs ->		
		out << render(template:"/tagLibTemplates/BreadCrumTagLib")
	}

	def cruderror = {attrs ->		
		out << render(template:"/tagLibTemplates/CrudErrorTagLib", model:[attrs:attrs])
	}

	def flashmessage = {attrs ->		
		out << render(template:"/tagLibTemplates/FlashMessageTagLib", model:[attrs:attrs])
	}


}
