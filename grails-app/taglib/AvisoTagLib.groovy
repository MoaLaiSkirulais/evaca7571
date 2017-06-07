class AvisoTagLib {
	
	static namespace = "aviso"

	def productImages = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/productImages")
	}

	def productDetails = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/productDetails")
	}

	def tabsWrapper = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/tabsWrapper")
	}

}
