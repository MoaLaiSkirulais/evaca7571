class FooterTagLib {
	
	static namespace = "evaca"

	def instagram = {attrs ->		
		out << render(template:"/tagLibTemplates/InstagramTagLib")
	}


}
