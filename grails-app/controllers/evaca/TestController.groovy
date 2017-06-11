package evaca

class TestController {

    def index() { 
		
		flash.message = "Test!"	
		respond view:'index'
		
	}
}
