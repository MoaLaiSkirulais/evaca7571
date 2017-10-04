class FormTagLib {
	
	static namespace = "myform"
	
	/* display */
	def display = {attrs ->		
		out << render(template:"/tagLibTemplates/FormTagLib/display", model:[attrs:attrs])
	}

	/* show */
	def show = {attrs ->		
		out << render(template:"/tagLibTemplates/FormTagLib/show", model:[attrs:attrs])
	}

	/* separator */
	def separator = {attrs ->		
		out << render(template:"/tagLibTemplates/FormTagLib/separator", model:[attrs:attrs])
	}

	/* field */
	def field = {attrs, body ->	

		if (attrs.value == null) {
			attrs.value = ""
		}

		if (attrs.type == null) {
			attrs.type = ""
		}

		out << render(template:"/tagLibTemplates/FormTagLib/field", model:[attrs:attrs])
	}

	/* select */
	def select = {attrs, body ->		
		out << render(template:"/tagLibTemplates/FormTagLib/select", model:[attrs:attrs])
	}

	/* radio */
	def radio = {attrs, body ->
	
		println attrs.type
		def ulStyle = ""
		def liStyle = ""
		if (attrs.type) {ulStyle = "style=\"list-style-type: none;\""} 
		if (attrs.type) {liStyle = "style=\"display: inline;\""} 
	
		out << "<tr class=\"cart-subtotal\">"
		out << 		"<th>${attrs.label}</th>"
		out << 		"<td class=\"text-right\">"
		out << 			"<span class=\"amount\">"
		out <<				"<ul class=\"payment-methods\" ${ulStyle}>"
		out <<					"<fieldset id=\"${attrs.name}\">"

		attrs.from.each {		
			def checked = ""
			if (it == attrs.value){
				checked = "checked=\"checked\""
			}
			out << "<li class=\"payment-method\" ${liStyle}>"
			out << 		"<input id=\"${it}\" name=\"${attrs.name}\" type=\"radio\" value=\"${it}\" ${checked}>\r"
			out << 		"<label for=\"${it}\" class=\"radio\">${it}</label>\r"
			out << "</li>"
		}
		
		out <<					"</fieldset>"
		out << 				"</ul>"
		out << 			"</span>"
		out << 		"</td>"
		out << "</tr>"
		
		
	}
	
	
	// /* radio */
	// def radio = {attrs, body ->
	
		// println attrs.type
		// def ulStyle = ""
		// def liStyle = ""
	

		// out <<	"<fieldset id=\"${attrs.name}\">"

		// attrs.from.each {		
			// def checked = ""
			// out <<	"<input id=\"${it}\" name=\"${attrs.name}\" type=\"radio\">\r"
		// }
		
		// out <<	"</fieldset>"

		
	// }

}
