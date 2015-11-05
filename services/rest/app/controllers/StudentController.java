package controllers;

import actions.CorsComposition.Cors;
import play.mvc.Controller;
import play.mvc.Result;

@Cors
public class StudentController extends Controller {
	
	public Result create() {
		
		return ok();
	}
}
