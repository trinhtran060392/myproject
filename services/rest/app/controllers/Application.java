package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import actions.CorsComposition.Cors;

@Cors
public class Application extends Controller {

	public static Result preflight(String path) {
	    return ok("");
	  }

}
