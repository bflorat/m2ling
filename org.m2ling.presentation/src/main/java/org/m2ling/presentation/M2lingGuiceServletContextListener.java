/**
 * Sample code from https://vaadin.com/wiki/-/wiki/Main/Integrating%20Vaadin%20with%20Guice%202.0?p_r_p_185834411_title=Integrating%2520Vaadin%2520with%2520Guice%25202.0 */

package org.m2ling.presentation;

import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.binding.DebugGuiceModule;
import org.m2ling.presentation.binding.PresentationCommonGuiceModule;
import org.m2ling.presentation.binding.PresentationPrincipleGuiceModule;
import org.m2ling.service.common.ServicesCommonGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.util.Modules;
import com.vaadin.Application;

/**
 * Listener creating the guice injector
 */
public class M2lingGuiceServletContextListener extends GuiceServletContextListener {

	private static Injector injector;

	@Override
	protected Injector getInjector() {

		ServletModule module = new ServletModule() {
			@Override
			protected void configureServlets() {
				// Servlet specific bindings, we serve '*', not only /* to also handle url without
				// trailing '/'
				serve("*").with(GuiceApplicationServlet.class);
				bind(Application.class).to(M2lingApplication.class);

				// Presentation layer bindings
				install(new PresentationCommonGuiceModule());
				install(new PresentationPrincipleGuiceModule());

				// Services layer bindings
				install(new ServicesCommonGuiceModule());
			}
		};
		if (Utils.isDebugMode()) {
			// Add any debug level bindings
			Module finalModule = Modules.override(module).with(new DebugGuiceModule());
			injector = Guice.createInjector(Stage.DEVELOPMENT, finalModule);
		} else {
			injector = Guice.createInjector(Stage.PRODUCTION, module);
		}
		return injector;
	}

	/**
	 * Return the cached injector. Use it only for the rare on-demand injection cases !
	 * 
	 * @return the cached injector
	 */

	public static Injector getCachedInjector() {
		return injector;
	}
}
