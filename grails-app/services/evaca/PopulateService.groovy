package evaca

import grails.transaction.Transactional

@Transactional
class PopulateService {
 
	/* lotes */
	def lotes() {

		log.info "Populando lotes..."
		
		// def r = Raza.first()
		// def c = Categoria.first()

		new Lote(
			raza: Raza.list()[2], 
			categoria: Categoria.list()[2], 
			fechaCreacion: new Date(), 
			cantidad: 90, 
			pesoPromedio: 440, 
			pesoMaximo: 500, 
			pesoMinimo: 350, 
			trazada: true, 
			ubicacion: "Pila, Buenos Aires", 
			edad: 1, 
			descarte: "", 
			marcaLiquida: true, 
			pesada: "", 
			desbaste: "", 
			cuit: "1-22344566-22", 
			precio: 10000, 
			tiempoDePago: 1
		).save()
		
		
		new Lote(
			raza: Raza.list()[1], 
			categoria: Categoria.list()[1], 
			fechaCreacion: new Date(), 
			cantidad: 7, 
			pesoPromedio: 440, 
			pesoMaximo: 500, 
			pesoMinimo: 350, 
			trazada: true, 
			ubicacion: "Lavalle, Buenos Aires", 
			edad: 1, 
			descarte: "", 
			marcaLiquida: false, 
			pesada: "", 
			desbaste: "", 
			cuit: "1-22344566-22", 
			precio: 2000, 
			tiempoDePago: 1
		).save()
		
		
		new Lote(
			raza: Raza.list()[3], 
			categoria: Categoria.list()[3], 
			fechaCreacion: new Date(), 
			cantidad: 15, 
			pesoPromedio: 300, 
			pesoMaximo: 500, 
			pesoMinimo: 250, 
			trazada: true, 
			ubicacion: "San Justo, Santa Fe", 
			edad: 1, 
			descarte: "", 
			marcaLiquida: true, 
			pesada: "", 
			desbaste: "", 
			cuit: "1-22344566-22", 
			precio: 3200, 
			tiempoDePago: 1
		).save()

		return 1
	}

	/* avisos */
	def avisos() {

		log.info "Populando avisos..."
		
		new Aviso(
			lote: Lote.list()[1], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Draft",
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[1], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Active",
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[2], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Draft",
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[2], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Active",
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[3], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Vendido",
			precio: 3200
		).save()
		
		return
	}

	/* ofertas */
	def ofertas() {

		log.info "Populando ofertas..."
		
		new Oferta(
			aviso: Aviso.list()[2], 
			usuario: Usuario.list()[3], 
			fechaCreacion: new Date()
		).save()
		
		new Oferta(
			aviso: Aviso.list()[2], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date()
		).save()
		
		new Oferta(
			aviso: Aviso.list()[2], 
			usuario: Usuario.list()[1], 
			fechaCreacion: new Date()
		).save()
		
		new Oferta(
			aviso: Aviso.list()[4], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date()
		).save()
		
		new Oferta(
			aviso: Aviso.list()[5], 
			usuario: Usuario.list()[3], 
			fechaCreacion: new Date()
		).save()
		
		new Oferta(
			aviso: Aviso.list()[5], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date()
		).save()
		
		new Oferta(
			aviso: Aviso.list()[5], 
			usuario: Usuario.list()[1], 
			fechaCreacion: new Date()
		).save()

		return
	}
	
	/* ventas */
	def ventas() {

		log.info "Populando ventas..."
		
		new Venta(
			oferta: Oferta.list()[1], 
			fechaCreacion: new Date()
		).save()

		new Venta(
			oferta: Oferta.list()[3], 
			fechaCreacion: new Date()
		).save()

		new Venta(
			oferta: Oferta.list()[6], 
			fechaCreacion: new Date()
		).save()

		return
	}	
	
	/* resenas */
	def resenas() {

		log.info "Populando resenas..."
		
		new Resena( 
			puntaje:3,
			comentario: "muy bien todo",
			venta: Venta.list()[1], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date()
		).save()

		new Resena( 
			puntaje:5,
			comentario: "excelente",
			venta: Venta.list()[2], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date()
		).save()

		new Resena( 
			puntaje:1,
			comentario: "mala la experiencia",
			venta: Venta.list()[3], 
			usuario: Usuario.list()[2], 
			fechaCreacion: new Date()
		).save()

		new Resena( 
			puntaje:2,
			comentario: "mal",
			venta: Venta.list()[3], 
			usuario: Usuario.list()[1], 
			fechaCreacion: new Date()
		).save()

		return
	}
}
