package evaca

class Reply {

	String content
	Post post
	
	static belongsTo = [post:Post] 
	
	public Reply() {
	}


}

