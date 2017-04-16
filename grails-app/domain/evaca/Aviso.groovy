package evaca

class Aviso {

	Date fechaCreacion
	Date fechaPublicacion
	String tbState
	Float precio
	
	Lote lote      
	static belongsTo = [lote:Lote]
 
	static constraints = {

		tbState blank: false, nullable: false
		tbState inList: [
			'Draft',
			'Active',
			'Inactive',
			'Finished',
			'Vendido'
		]

	}
	
    public void setTbState(String tbState) {
		if (tbState == 'Active'){
			this.tbState = 'Finished'
		} else {
			this.tbState = tbState
		}
    }

}
