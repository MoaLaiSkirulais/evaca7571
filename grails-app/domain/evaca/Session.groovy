package evaca

class Session {

	Date fechaCreacion	
	String username
	Usuario owner
	
	static constraints = {
	
		// fechaCreacion blank: false, nullable: false
		fechaCreacion blank: true, nullable: true
		owner blank: true, nullable: true

    }
	
	def beforeInsert() {
		println "beforeInsert"
		this.fechaCreacion = new Date()
		this.owner = Usuario.list()[2]
	}
	
	// def beforeUpdate() {
		// // println "beforeInsert"
		// // this.fechaCreacion = new Date()
		// // this.owner = Usuario.list()[2]
	// }
	
	def beforeValidate() {
		println "beforeValidate"
		// this.fechaCreacion = new Date()
    }

}

