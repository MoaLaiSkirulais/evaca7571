// new Usuario(
	// fechaCreacion: new Date(), 
	// username: "userbl", 
	// nombre: "Usuario", 
	// apellido: "Logica", 
	// email: "ulogica@gmail.com", 
	// tbTipo: "Consignatario", 
	// password: "usuario", 
	// tbState: "Activo", 
	// comision: 11					
// ).save()

// new Lote(
	// usuario: Usuario.last(), 
	// raza: Raza.list()[2], 
	// categoria: Categoria.list()[2], 
	// fechaCreacion: new Date(), 
	// cantidad: 90, 
	// pesoPromedio: 440, 
	// pesoMaximo: 500, 
	// pesoMinimo: 350, 
	// trazada: true, 
	// ubicacion: "Pila, Buenos Aires", 
	// edad: 1, 
	// marcaLiquida: true, 
	// cuit: "1-22344566-22", 
	// precio: 10000, 
	// tiempoDePago: 1
// ).save()

// new Aviso(
	// lote: Lote.last(), 
	// fechaCreacion: new Date(), 
	// fechaPublicacion: new Date(), 
	// tbState: "Draft",
	// precio: 3200
// ).save()

// def a = Aviso.last()
// a.setTbState("Active")
// a.save(flush:true)
// a.list()
