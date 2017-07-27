package acme

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		"/test"(controller:"test") 
		"/home"(controller:"home") 
		// "/form"(controller:"home", action:"form") 
		"/form"(controller:"home", action:"bookData") 
		"/milayout" (controller:"home", action:"milayout", view: "milayout") 
	    "/caca"(view: "/caca")  
	    "/field"(controller:"field", action:"index")
	    "/plugins"(controller:"field", action:"plugins", view: "plugins")
        "/"{controller = "home"}
        "500"(view:'/error')
        "404"(view:'/notFound')
		"/$controller"(action: "redirect", controller: "project")
    }
}

