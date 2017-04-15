package evaca

class Resena {
	
	
	Date fechaCreacion
	Integer puntaje
	String comentario
	
	Venta venta
	Usuario usuario
	static belongsTo = [venta:Venta, usuario:Usuario] 
	
	static constraints = {
		}
}
