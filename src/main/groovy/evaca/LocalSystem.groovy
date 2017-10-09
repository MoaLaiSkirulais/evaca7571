package evaca

/* LocalSystem */	
class LocalSystem {
	
	
	/* getDataResource */	
	static String getDataResource(String resource){

		String root = new File(".").getAbsolutePath()
		// String path1 = System.properties['user.dir'] + "/data" + resource
		String path1 = root + "/data" + resource
		return path1
		
	}
	
	
}

