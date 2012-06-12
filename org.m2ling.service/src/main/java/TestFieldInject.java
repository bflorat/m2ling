import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */

/**
 * 
 */
public class TestFieldInject {
	
	
	public static void main(String[] args){
		Injector inj = Guice.createInjector(new TestModule());
		A a = inj.getInstance(A.class);
		System.out.println(a.getB());
		
	}
	
	static class TestModule extends AbstractModule{

		/* (non-Javadoc)
		 * @see com.google.inject.AbstractModule#configure()
		 */
		@Override
		protected void configure() {
		//	bind(B.class);
	//		bind(A.class);
			
		}
		
	}
	
	@Singleton
	static class A{
		@Inject 
		B b;
		
		B getB(){
			return b;
		}
	}
	
	@Singleton
	static class B{
		
	}

}
