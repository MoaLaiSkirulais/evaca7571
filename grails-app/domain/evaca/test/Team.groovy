package evaca.test

class Team {

	String name
	String state

	List<Player> players /* al pedo? */
	static hasMany = [players: Player]

}

