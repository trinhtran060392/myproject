package com.trinhtv3.services.student;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trinhtv3.services.database.MongoDBService;


public class StudentServiceTestCase {
	
	private Injector inject;
	
	private MongoDBService mongo;
	
	private StudentService studentService;
	
	@BeforeClass
	public void init() {
		
		this.inject = Guice.createInjector(new StudentServiceModule());
		this.mongo = this.inject.getInstance(MongoDBService.class);
		this.studentService = this.inject.getInstance(StudentService.class);
		
	}
	
	@AfterMethod
	public void tearDown() {
		this.mongo.dropDatabase();
	}
	
	@Test
	public void testList() {
		
		initData();
		Assert.assertEquals(this.studentService.count(), 20);
	}
	
	@Test
	public void testGetStudent() {
		initData();
		Student s = this.studentService.getAll().get(0);
		
		Assert.assertEquals(s.getName(), "test0");
	}
	
	@Test
	public void testDelete() {
		initData();
		
		Student s = new Student("trinh");
		this.studentService.create(s);
		this.studentService.delete(s);
		Assert.assertEquals(this.studentService.count(), 20);
		
	}
	
	
	private void initData() {
		for (int i = 0; i < 20; i ++ ) {
			Student s = new Student("test"+ i);
			this.studentService.create(s);
		}
	}
}
