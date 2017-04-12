package com.acme.app

class SimpleController {

	/* index() */
    def index() { 
		redirect action: 'hello'
	}
	
	/* hello() */
	def hello() {
        render "hello"
    }
	
	def home() {
        render view: "homePage", model: [title: "Hello World"]
    }
}