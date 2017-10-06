package evaca

/* ErrorHandler */	
class ErrorHandler {
	
	
	/* build */	
	static String build(String defaultMessage, def arguments){

		String str2 = defaultMessage.replace(/[{0}]/, arguments)
		str2 = str2.replace(/ de la clase [{1}]/, '')
		str2 = str2.replace(/ con valor [{2}]/, '')

		return str2

		
	}
	
	
}

