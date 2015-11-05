package com.trinhtv3.services.student;

import com.google.inject.AbstractModule;
import com.trinhtv3.services.database.MongoDBService;

public class StudentServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(StudentService.class);
	}

}
