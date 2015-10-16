package com.blogspot.mikelaud.fp;

public interface Component {

	interface Info { // POJO read-only
		
		int getId();
		String getField();		
	}
	
	interface Data extends Info { // POJO read-write

		void setId(int aId);
		void setField(String aField);

		void set(Info aInfo);
	}
	
	interface Factory { // Component factory
		
		Data getData();
		Component create();
	}

	Info getInfo();
}
