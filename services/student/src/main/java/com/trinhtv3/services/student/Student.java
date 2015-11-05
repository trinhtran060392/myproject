package com.trinhtv3.services.student;

import java.util.UUID;

import com.mongodb.BasicDBObject;

public class Student extends BasicDBObject {
	
	public Student() {}
	public Student(String name) {
		this.put("_id", UUID.randomUUID());
		this.put("name", name);
	}
	
	public String getName() {
		return this.getString("name");
		
	}
	public void setName(String name) {
		this.put("name", name);
	}
	
}
