package evaca

import evaca.Raza


class BootStrap {

    def init = { servletContext ->
		
		new Raza(name: "Aberdeen Angus").save()
		new Raza(name: "Braford").save()
		new Raza(name: "Holando Argentino").save()
		new Raza(name: "Cruza").save()
		new Raza(name: "Hereford").save()
		new Raza(name: "Jersey").save()
		new Raza(name: "Bovino Criollo").save()
		new Raza(name: "Brangus").save()
		new Raza(name: "Careta").save()
		
    }
    def destroy = {
    }
}
