class AvisoTagLib {
	
	static namespace = "aviso"

	def productImages = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/productImages", model:[attrs:attrs])
	}

	def productDetails = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/productDetails", model:[attrs:attrs])
	}
	
	def tabsWrapper = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/tabsWrapper", model:[attrs:attrs])
	}

	def oferta = {attrs ->		
		out << render(template:"/tagLibTemplates/AvisoTagLib/oferta", model:[attrs:attrs])
	}

	def tabInformation = {attrs ->
		out << render(template:"/tagLibTemplates/AvisoTagLib/tabInformation", model:[attrs:attrs])
	}

	def tabOfertas = {attrs ->
		out << render(template:"/tagLibTemplates/AvisoTagLib/tabOfertas", model:[attrs:attrs])
	}

	def tabResenas = {attrs ->
		out << render(template:"/tagLibTemplates/AvisoTagLib/tabResenas", model:[attrs:attrs])
	}

}
