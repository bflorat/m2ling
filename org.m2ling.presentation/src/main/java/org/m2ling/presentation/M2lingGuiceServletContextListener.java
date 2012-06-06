/**
 * Sample code from https://vaadin.com/wiki/-/wiki/Main/Integrating%20Vaadin%20with%20Guice%202.0?p_r_p_185834411_title=Integrating%2520Vaadin%2520with%2520Guice%25202.0 */

package org.m2ling.presentation;

import org.m2ling.presentation.principles.PresentationCommonGuiceModule;
import org.m2ling.presentation.principles.PresentationPrincipleGuiceModule;
import org.m2ling.service.common.ServicesCommonGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.servlet.ServletScopes;
import com.vaadin.Application;

/**
 * Listener creating the guice injector
 */
public class M2lingGuiceServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		ServletModule module = new ServletModule() {
			@Override
			protected void configureServlets() {
				// Servlet specific bindings
				serve("/*").with(GuiceApplicationServlet.class);
				bind(Application.class).to(M2lingApplication.class).in(ServletScopes.SESSION);

				// Presentation layer bindings
				install(new PresentationCommonGuiceModule());
				install(new PresentationPrincipleGuiceModule());

				// Services layer bindings
				install(new ServicesCommonGuiceModule());
			}
		};

		Injector injector = Guice.createInjector(module);
		return injector;
	}
}
