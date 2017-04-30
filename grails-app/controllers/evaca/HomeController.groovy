package evaca

/* 
 * Book
 */
 
class Book {

	Integer id
	String author
	String title
	
	public Book(String author, String title){
		this.author = author;
		this.title = title;      
		this.id = 1;      
	}
}

/* 
 * HomeController
 */
 
class HomeController {

    def index() {
        // respond([name: session.name ?: 'User', vehicleTotal: Vehicle.count()]) 

		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("Stephen King", "Joe"));
		books.add(new Book("Steve", "Steve")); 

        respond([name: session.name, books:books]) 
    }

    def form() {

		ArrayList<Book> books = new ArrayList<Book>();
		Book joe = new Book("Stephen King", "Joe"); 
		books.add(joe);
		Book steve = new Book("Steve", "Steve");
		books.add(steve);            

        respond([name: session.name, books:books, myBook:steve]) 
    }
	
	def bookData() {
	
		// def b = new Book("Stephen King", "Joe"); 
		// render(template:"bookTemplate", model:[book:b])
		
	    def b = new Book("Steve", "Steve");
		String content = g.render(template:"bookTemplate", model:[book:b])
		log.info "Configuration data source"
		render content

	}
	
    def list() { 
		// render(view:"list");
		Book steve = new Book("Steve", "Steve");
        respond([myBook:steve]) 
	}

    // def paramssample() { 
		// { render params.id }

	// }


	def milayout() {
	
	    // static layout = 'milayout'

		render(view:"milayout");

	}


    def updateName(String name) {
        session.name = name 

        flash.message = "Name has been updated" 

        redirect action: 'index' 
    }

}
