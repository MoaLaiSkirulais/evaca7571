package evaca

class AvisoTagLib {
	
	static namespace = "aviso"
	static defaultEncodeAs = "raw"

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
	 
	def entityState = {attrs ->
	
		String sState = attrs.state
		
		if (sState == "APROBADO") {
			out << "<span style=\"color:green\">${attrs.state}</span>"
		}
		
		if (sState == "POSTULADO") {
			out << "<span style=\"color:#E74C3C\">${attrs.state}</span>"
		}
		
		if (sState == "DESAPROBADO") {
			out << "<span style=\"color:silver\">${attrs.state}</span>"
		}
		
		if (sState == "ACEPTADO") {
			out << "<span style=\"color:blue\">${attrs.state}</span>"
		}
		
		if (sState == "BORRADOR") {
			out << "<span style=\"color:peru\">${attrs.state}</span>"
		}
		
		if (sState == "VENDIDO") {
			out << "<span style=\"color:blue\">${attrs.state}</span>"
		}
		
		if (sState == "PUBLICADO") {
			out << "<span style=\"color:red\">${attrs.state}</span>"
		}
		
		if (sState == "DISPONIBLE") {
			out << "<span style=\"color:green\">${attrs.state}</span>"
		}
		
	}

}
