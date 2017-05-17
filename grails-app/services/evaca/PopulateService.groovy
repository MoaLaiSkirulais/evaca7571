// http://themes.iamabdus.com/bigbag/1.2/list-panel.html#
// http://wrapbootstrap.com/preview/WB02DSN1B

package evaca

import grails.transaction.Transactional

@Transactional
class PopulateService {
 
	/* razas */
	def razas() {

		log.info "Populando razas..."
		new Raza(name: "Aberdeen Angus").save()
		new Raza(name: "Braford").save()
		new Raza(name: "Holando Argentino").save()
		new Raza(name: "Cruza").save()
		new Raza(name: "Hereford").save()
		new Raza(name: "Jersey").save()
		new Raza(name: "Bovino Criollo").save()
		new Raza(name: "Brangus").save()
		new Raza(name: "Careta").save()
		return 1
	}

	/* categorias */
	def categorias() {

		log.info "Populando categorias..."
		new Categoria(name: "Preñadas").save()
		new Categoria(name: "Con Ternero al Pie").save()
		new Categoria(name: "Vacias").save()
		new Categoria(name: "De Descarte").save()
		new Categoria(name: "Con Servicio").save()
		return 1
	}

	/* usuarios */
	def usuarios() {

		log.info "Populando usuarios..."
		
		new Usuario(
			fechaCreacion: new Date(), 
			username: "lcastro", 
			nombre: "Leo", 
			apellido: "Castro", 
			email: "leocastro@gmail.com", 
			tbTipo: "Consignatario", 
			password: "Castro", 
			tbState: "Activo", 
			// puntaje: 11, 
			comision: 11					
		).save()
		
		new Usuario(
			fechaCreacion: new Date(), 
			username: "mporto", 
			nombre: "Martin", 
			apellido: "Porto", 
			email: "martinporto@gmail.com", 
			tbTipo: "Productor", 
			password: "Castro", 
			tbState: "Activo", 
			// puntaje: 11, 
			comision: 11					
		).save()
		
		new Usuario(
			fechaCreacion: new Date(),  
			username: "dguglie", 
			nombre: "Damian", 
			apellido: "Guglielmoti", 
			email: "dguglie@gmail.com", 
			tbTipo: "Productor", 
			password: "Castro", 
			tbState: "Pendiente", 
			// puntaje: 11, 
			comision: 11					
		).save()

		return 1
	}

	/* lotes */
	def lotes() {

		log.info "Populando lotes..."
		
		// def r = Raza.first()
		// def c = Categoria.first()

		new Lote(
			usuario: Usuario.last(), 
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
			usuario: Usuario.last(), 
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
			usuario: Usuario.last(), 
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
			tbState: "Borrador",
			consignatario: Usuario.list()[2], 
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[1], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Borrador",
			consignatario: Usuario.list()[2], 
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[2], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Borrador",
			consignatario: Usuario.list()[2], 
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[2], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Borrador",
			consignatario: Usuario.list()[2], 
			precio: 3200
		).save()
		
		new Aviso(
			lote: Lote.list()[3], 
			fechaCreacion: new Date(), 
			fechaPublicacion: new Date(), 
			tbState: "Vendido",
			consignatario: Usuario.list()[2], 
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
	
	/* preguntas */
	def preguntas() {

		log.info "Populando preguntas..."
		
		new Pregunta( 			
			fechaCreacion: new Date(), 
			label: "Como fue la comunicacion con el vendedor?"
		).save()

		new Pregunta( 			
			fechaCreacion: new Date(), 
			label: "Como fue la comunicacion con el consignatario?"
		).save()

		new Pregunta( 			
			fechaCreacion: new Date(), 
			label: "Cual es el estado del lote?"
		).save()

		new Pregunta( 			
			fechaCreacion: new Date(), 
			label: "Volveria a comprar?"
		).save()

		new Pregunta( 			
			fechaCreacion: new Date(), 
			label: "Que le parecio el sistema?"
		).save()

		return
	}
	
	/* all */
	def all() {

		razas()
		categorias()
		usuarios()
		lotes()
		avisos()
		ofertas()
		ventas()
		resenas()
		preguntas()
	}
	
	/* showAll */
	def showAll() {

		println Raza.list().toString()
		println Categoria.list().toString()
		println Usuario.list().toString()
		println Lote.list().toString()
		println Aviso.list().toString()
		println Oferta.list().toString()
		println Venta.list().toString()
		println Resena.list().toString()
		println Pregunta.list().toString()
	}	
	
	/* countAll */
	def countAll() {

		println "Raza" + Raza.list().size()
		println "Categoria" + Categoria.list().size()
		println "Usuario" + Usuario.list().size()
		println "Lote" + Lote.list().size()
		println "Aviso" + Aviso.list().size()
		println "Oferta" + Oferta.list().size()
		println "Venta" + Venta.list().size()
		println "Resena" + Resena.list().size()
		println "Pregunta" + Pregunta.list().size()

	}
}
