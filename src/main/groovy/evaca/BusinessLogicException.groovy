package evaca;

/**
 * Clase base para las Excepciones de Reglas de Negocio
 * 
 * @author Moalais
 * 
 */
public class BusinessLogicException extends RuntimeException implements Descriptible {
	
	String message = "Violación de Regla de Negocio";
	Map model
	
	// public BusinessLogicException([]) {
	// }

	
    @Override
    public String getDescripcion() {
        return message;
    }


}
