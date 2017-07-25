package evaca;

/**
 * Clase base para las Excepciones de Reglas de Negocio
 * 
 * @author Moalais
 * 
 */
class UsuarioNotFoundException extends RuntimeException {
	
	String message = "No se encontró el usuario";
	Map model

}
