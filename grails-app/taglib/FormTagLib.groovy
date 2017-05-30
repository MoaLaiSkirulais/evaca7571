class FormTagLib {
	
	static namespace = "myform"
	
	/* display */
	def display = {attrs ->		
		out << render(template:"/tagLibTemplates/FormTagLib/display", model:[attrs:attrs])
	}

	/* field */
	def field = {attrs, body ->	

		if (attrs.value == null) {
			attrs.value = ""
		}

		out << "<tr class=\"cart-subtotal\">"
		out << 		"<th>${attrs.label}</th>"
		out << 		"<td class=\"text-right\">"
		out << 			"<span class=\"amount\">"
		// out << 				"<f:field bean=\"${attrs.value}\" property=\"nombre\"/>"
		out << 				"<input value=\"${attrs.value}\" name=\"${attrs.name}\"/>"
		// out << 				 f.field(bean:"categoria", property:attrs.value)
		out << 			"</span>"
		out << 		"</td>"
		out << "</tr>"
	}

	/* select */
	def select = {attrs, body ->		
		out << render(template:"/tagLibTemplates/FormTagLib/select", model:[attrs:attrs])
	}

	/* radio */
	def radio = {attrs, body ->
	
		out << "<tr class=\"cart-subtotal\">"
		out << 		"<th>${attrs.label}</th>"
		out << 		"<td class=\"text-right\">"
		out << 			"<span class=\"amount\">"
		out <<				"<ul class=\"payment-methods\">"
				
		attrs.from.each {		
			def checked = ""
			if (it == attrs.value){
				checked = "checked=\"checked\""
			}
			out << "<li class=\"payment-method\">"
			out << 		"<input id=\"${it}\" name=\"${attrs.name}\" type=\"radio\" value=\"${it}\" ${checked}>\r"
			out << 		"<label for=\"${it}\" class=\"radio\">${it}</label>\r"
			// out << g.radio(name:attrs.name, value:it, checked:(it == attrs.value))			
			// out << "${it}<br>"
			// out << attrs
			out << "</li>"
		}
		out << 				"</ul>"
		out << 			"</span>"
		out << 		"</td>"
		out << "</tr>"
		
		
	}

}
