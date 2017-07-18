package evaca


class Customer {

	String name
	String status
	String account

	private def Customer() {}
	def Customer(String name, String account)  {
		this.name = name
		this.status = "NEW"
		this.account = account
	}

	void setName(final String other) { name = other }
	void setStatus(final String other)  { status = other }
	void setAccount(final String other) { account = other }


	// Grails Specific

	
	def static Customer create(final String name, final String account)  {
		return new Customer(name, account)
	}

	static constraints = {
		name(blank: false)
		status(nullable: false)
		account(nullable: false)
	}
}
