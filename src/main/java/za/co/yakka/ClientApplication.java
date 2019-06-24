
package za.co.yakka;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ClientApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ClientAPI.class);
		
		return classes;
		
	}
	
	@Override
	public Set<Object> getSingletons(){
		Set<Object> singletons = new HashSet<>();
		return singletons;
	}
}
