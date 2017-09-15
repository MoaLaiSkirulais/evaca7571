package evaca

class AvisoFinderTagLib {
	
	static namespace = "aviso"

	def finder = {attrs ->

		def model = 
			[
				topVendedores: Usuario.list(offset: 10, max: 5).sort{it.nombre},  
				nuevoUsuarios: Usuario.list(offset: 10, max: 15).sort{it.nombre}, 
				razas: Raza.list().sort{it.nombre}, 
				categorias:Categoria.list().sort{it.nombre}	
			]
		
		out << render(template:"/tagLibTemplates/AvisoFinderTagLib/finder", model:model)
	}


}
