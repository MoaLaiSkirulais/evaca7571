package evaca

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
	 
	def entityState = {attrs ->
	
		println attrs.state
		String sState = attrs.state
		
		// if (attrs.state == OfertaState.APROBADO) {
		if (sState == "APROBADO") {
			out << "<span style=\"color:green\">${attrs.state}</span>"
		}
		
		// if (attrs.state == OfertaState.POSTULADO) {
		if (sState == "POSTULADO") {
			out << "<span style=\"color:#E74C3C\">${attrs.state}</span>"
		}
		
		// if (attrs.state == OfertaState.DESAPROBADO) {
		if (sState == "DESAPROBADO") {
			out << "<span style=\"color:silver\">${attrs.state}</span>"
		}
		
		// if (attrs.state == OfertaState.ACEPTADO) {
		if (sState == "ACEPTADO") {
			out << "<span style=\"color:blue\">${attrs.state}</span>"
		}
		
	}

}
