class AvisoTagLib {
	
	static namespace = "aviso"

	def productImages = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/productImages", model:[attrs:attrs])
	}

	def productDetails = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/productDetails", model:[attrs:attrs])
	}
	
	def tabsWrapper = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/tabsWrapper")
	}

	def oferta = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/oferta", model:[attrs:attrs])
	}

}
