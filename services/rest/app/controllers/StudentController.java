package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.inject.Inject;
import com.trinhtv3.services.student.Student;
import com.trinhtv3.services.student.StudentService;

import actions.CorsComposition.Cors;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

@Cors
public class StudentController extends Controller {
	@Inject private StudentService service;
	
	public Result create() {
		
		JsonNode data = request().body().asJson();
		Student s = new Student(data.get("name").asText());
		
		service.create(s);
		
		return ok(Json.parse(s.toString()));
	}
	
	public Result list() {
		
		ArrayNode array = Json.newObject().arrayNode();
		List<Student> list = service.getAll();
		
		for (Student s : list) {
			array.add(Json.parse(s.toString()));
		}
		
		return ok(array);
	}
}
