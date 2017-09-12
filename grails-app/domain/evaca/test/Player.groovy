package evaca.test

class Player {

	String name
	String state
	
	Team team
	static belongsTo = [team:Team]
	
	
	/* Player */
	public Player() {
		this.state = "regular"
	}	
	
	
	/* beCaptain */
	public beCaptain() {
		this.state = "captain"
	}


	/* beRegular */
	public beRegular() {
		this.state = "regular"
	}



}

