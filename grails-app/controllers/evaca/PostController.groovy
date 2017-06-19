package evaca

class PostController {
	
	/* create */
	def create() {

		def post = new Post()
		post.content = "c0"

		def reply1 = new Reply()
		reply1.post = post
		reply1.content = "c1"
		post.addToReplies(reply1)

		def reply2 = new Reply()
		reply2.post = post
		reply2.content = "c2"
		post.addToReplies(reply2)
	
		def reply3 = new Reply()
		reply3.post = post
		reply3.content = "c3"
		post.addToReplies(reply3)

		[post: post]
    }
	
	/* edit */
	def edit() {
		respond view:'create', [post:new Post().get(params.id)]
    }

	/* save */
	def save(Post post) {

		if (!params.id){
			post = new Post(params)
		}

		post.save(flush:true)

		if (post.hasErrors()) {
			respond view:'create', [post:post]
			return
		}

		redirect action:"edit", id:post.id

		// render post
		// render "<br>"
		// render params
		// render "<br>"
		// post.save(flush:true)
		// def output =
		// post.replies 
		
		// post.errors.allErrors.each { render it }
		
		// + "<br>"
		// + post.encodeAsJSON()
		// + "<br>"
		// + post.replies[0].encodeAsJSON()
		// + "<br>"
		// + post.replies[1].encodeAsJSON()
		// + "<br>"
		// + post.replies[2].encodeAsJSON()
		// render output as JSON
		// render output.encodeAsJSON()

    }


}
