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
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
