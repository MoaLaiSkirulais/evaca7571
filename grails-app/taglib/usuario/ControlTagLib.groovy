package evaca

class ControlTagLib {
	
	static namespace = "usuario"
 
	def state2 = {attrs ->		
		out << "test"
	}
 
	def state = {attrs ->	
	
		if (attrs.value == UsuarioState.APROBADO){
			out << "<div class='usuario-aprobado'>" + attrs.value + "</div>"
		}

		if (attrs.value != UsuarioState.APROBADO){
			out << "<span class='usuario-other'>" + attrs.value + "</span>"
		}
	}

}
