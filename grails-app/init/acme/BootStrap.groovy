package evaca

import evaca.Raza
import evaca.Usuario


class BootStrap {

    def init = { servletContext ->
	
		/* Categoria */
		new Categoria(name: "Preñadas").save()
		new Categoria(name: "Con Ternero al Pie").save()
		new Categoria(name: "Vacias").save()
		new Categoria(name: "De Descarte").save()
		new Categoria(name: "Con Servicio").save()
		
		/* Raza */
		new Raza(name: "Aberdeen Angus").save()
		new Raza(name: "Braford").save()
		new Raza(name: "Holando Argentino").save()
		new Raza(name: "Cruza").save()
		new Raza(name: "Hereford").save()
		new Raza(name: "Jersey").save()
		new Raza(name: "Bovino Criollo").save()
		new Raza(name: "Brangus").save()
		new Raza(name: "Careta").save()
		
		new Usuario(
			fechaCreacion: "11/11/2011", 
			username: "lcastro", 
			nombre: "Leo", 
			apellido: "Castro", 
			email: "leocastro@gmail.com", 
			tbTipo: "Castro", 
			password: "Castro", 
			tbState: "Castro", 
			puntaje: 11, 
			comision: 11					
		).save()
		
		new Usuario(
			fechaCreacion: "11/11/2011", 
			username: "mporto", 
			nombre: "Martin", 
			apellido: "Porto", 
			email: "martinporto@gmail.com", 
			tbTipo: "Castro", 
			password: "Castro", 
			tbState: "Castro", 
			puntaje: 11, 
			comision: 11					
		).save()
		
		new Usuario(
			fechaCreacion: "11/11/2011", 
			username: "dguglie", 
			nombre: "Damian", 
			apellido: "Guglielmoti", 
			email: "dguglie@gmail.com", 
			tbTipo: "Castro", 
			password: "Castro", 
			tbState: "Castro", 
			puntaje: 11, 
			comision: 11					
		).save()

    }
    def destroy = {
    }
}
