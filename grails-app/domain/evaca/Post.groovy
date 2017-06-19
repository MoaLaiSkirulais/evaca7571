package evaca

class Post {

	String content
	List<Reply> replies
	
	static hasMany = [replies:Reply]
	
	public Post() {
	}


}

