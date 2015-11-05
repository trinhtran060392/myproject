package com.trinhtv3.services.database;

public interface DBService<D> {
	
	 public D getDatabase();
	  
	 public String getDatabaseName();
	  
	 public void dropDatabase();
	
}
