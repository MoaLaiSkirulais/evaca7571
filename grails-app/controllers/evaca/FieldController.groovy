package evaca

/* 
	* FieldController
 */
 
class FieldController {

    def index() {
	        
		Book steve = new Book("Steve", "Steve");
		Raza angus = new Raza(fechaCreacion: new Date(), name: "Aberdeen Angus");
		
        // respond([myBook:steve]) 
        respond([raza:angus, book: steve]) 
		// respond new Raza()
    }

    def plugins() {
	
		applicationContext.getBean('pluginManager').allPlugins.each {plugin ->
			println "${plugin.name} - ${plugin.version}"
		}

		respond([plugins:applicationContext.getBean('pluginManager').allPlugins]) 
        
		// render(view:"plugins");
    }


}
