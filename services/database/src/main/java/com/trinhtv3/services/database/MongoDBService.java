package com.trinhtv3.services.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBService implements DBService<DB> {
	
	private static final MongoClient client;
	
	private final String dbName = "student";
	
	static {
		try {
			client = new MongoClient();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public DB getDatabase() {
		return client.getDB(this.dbName);
	}

	@Override
	public String getDatabaseName() {
		return this.dbName;
	}

	@Override
	public void dropDatabase() {
		client.dropDatabase(this.dbName);
		
	}
	
	

}
