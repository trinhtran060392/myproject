package com.trinhtv3.services.database;

import com.google.inject.AbstractModule;

public class DBServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MongoDBService.class);
		
	}

}
