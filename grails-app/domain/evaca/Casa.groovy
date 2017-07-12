package evaca

class Casa {

	CasaStatus status
	String color
	String tipo
	String barrio
	
	enum CasaStatus {
		ENVENTA, VENDIDA, LIBRE;
	}

	public Casa(String color) {

		this.barrio = "telmo";
		// this.color = "rojo";
		this.color = color;
		this.tipo = "chalet";
		this.status = CasaStatus.LIBRE;

	}
	
	/* setTipo() */
	public void setTipo(String tipo){}
	
	/* setBarrio() */
	public void setBarrio(String barrio){}
	
	/* setColor() */
	public void setColor(String color){}
	
	/* setLote() */
	public void setStatus(CasaStatus status){
		
		println "status:" + status

		if (status == CasaStatus.ENVENTA){
			println "1"
			// if (this.status == CasaStatus.VENDIDA){
				// println "2"
				// throw new DomainException(message : "La casa esta VENDIDA")
			// }
			
			if (this.color == "rojo"){
				throw new DomainException(message : "No puede vender una casa roja")
			}
		}
		
		this.status = status
	}



}

