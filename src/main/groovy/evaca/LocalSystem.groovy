package evaca

/* LocalSystem */	
class LocalSystem {
	
	
	/* getDataResource */	
	static String getDataResource(String resource){

		String path1 = System.properties['user.dir'] + "/data" + resource
		return path1
		
	}
	
	
}

