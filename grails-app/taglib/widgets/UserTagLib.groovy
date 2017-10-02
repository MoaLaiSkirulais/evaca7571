class UserTagLib {
	
	static namespace = "user"
	
	def mySessionService
	def usuarioService

	def links = {attrs ->
		
		// if (mySessionService.isLogged()){ /* esta validacion debe ser redundante */
			// out << render(template: "/tagLibTemplates/UserTagLib/links", model:[usuario:Usuario.findByNombre("administrador")])
			out << 
				render(
					template: "/tagLibTemplates/UserTagLib/links", 
					// model:[usuario:usuarioService.edit(1)]
					model:[usuario:mySessionService.usuario]
				)
		// }
	}

	def accesos = {attrs ->

		out << 
			render(
				template: "/tagLibTemplates/UserTagLib/accesos", 
				model:[usuario:mySessionService.usuario]
			)		
	}

 
}
