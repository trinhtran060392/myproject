import play.Application;
import play.GlobalSettings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trinhtv3.services.student.StudentServiceModule;


public class Global extends GlobalSettings {
  
  /** .*/
  private Injector injector;
  
  @Override
  public void onStart(Application app) {
    
	  this.injector = Guice.createInjector(new StudentServiceModule());
    
   
    super.onStart(app);
  }
  
  public <T> T getControllerInstance(Class<T> aClass) throws Exception {
    return injector.getInstance(aClass);
  }
  
  
}
