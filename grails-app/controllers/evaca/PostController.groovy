package evaca

class PostController {
	
	/* create */
	def create() {
		
		def post = new Post()
		
		def reply1 = new Reply()
		reply1.post = post
		post.addToReplies(reply1)

		def reply2 = new Reply()
		reply2.post = post
		post.addToReplies(reply2)
	
		def reply3 = new Reply()
		reply3.post = post
		post.addToReplies(reply3)

		[post: post]
    }
	
	//Register Review domain for JSON rendering
	// JSON.registerObjectMarshaller(Post) {
		// def output = [:]
		// output['id'] = it.id
		// output['content'] = it.content
		// output['replies'] = ["id": it.reply.id, "content": it.reply.content]
		// return output;
	// }

	/* save */
	def save(Post post) {
		
		// render post
		// render "<br>"
		// render params
		// render "<br>"
		post.save(flush:true)
		def output =
		post.replies 
		// + "<br>"
		// + post.encodeAsJSON()
		// + "<br>"
		// + post.replies[0].encodeAsJSON()
		// + "<br>"
		// + post.replies[1].encodeAsJSON()
		// + "<br>"
		// + post.replies[2].encodeAsJSON()
		// render output as JSON
		render output.encodeAsJSON()

    }


}
