package evaca

import grails.validation.Validateable

/* SaveCommand */
class SaveCommand implements Validateable {
    
	Raza raza	
	Categoria categoria
	Integer cantidad
	String ubicacion
	String provincia
	Integer pesoPromedio
	Integer pesoMaximo
	Integer pesoMinimo
	Integer edad
	Boolean trazada
	Boolean marcaLiquida
	String imagen
	byte[] loteImageBytes 

    static constraints = {    
    }
}