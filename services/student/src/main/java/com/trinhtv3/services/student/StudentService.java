package com.trinhtv3.services.student;

import com.google.inject.Inject;
import com.mongodb.DBObject;
import com.trinhtv3.services.database.MongoDBService;

public class StudentService extends MongoAbstractCRUD<Student> {
	
	private final String col_name = "info";
	
	@Inject
	public StudentService(MongoDBService mongo) {
		this.col = mongo.getDatabase().getCollection(col_name);
	}
	
	@Override
	public Student transform(DBObject source) {
		Student s = new Student();
		s.put("_id", source.get("_id").toString());
		s.setName(source.get("name").toString());
		return s;
	}

}
