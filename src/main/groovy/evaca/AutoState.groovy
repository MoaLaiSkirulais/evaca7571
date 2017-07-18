package evaca

/* AutoState */	
public enum AutoState {         

	APAGADO, 
	MARCHA, 
	ENCENDIDO {
		 
        @Override
        public boolean isValid() {
            return true;
        }

	}
	
	public boolean isValid() {
        return true;
    }

	
}


