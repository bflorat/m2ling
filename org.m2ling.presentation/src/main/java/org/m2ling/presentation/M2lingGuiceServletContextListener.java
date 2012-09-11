/**
 * Sample code from https://vaadin.com/wiki/-/wiki/Main/Integrating%20Vaadin%20with%20Guice%202.0?p_r_p_185834411_title=Integrating%2520Vaadin%2520with%2520Guice%25202.0 */
package org.m2ling.presentation;

import java.util.HashMap;
import java.util.Map;

import org.m2ling.common.configuration.Conf.SpecificConfiguration;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.binding.DebugGuiceModule;
import org.m2ling.presentation.binding.PresentationCommonGuiceModule;
import org.m2ling.presentation.binding.PresentationPrincipleGuiceModule;
import org.m2ling.service.common.ServicesCommonGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.util.Modules;
import com.vaadin.Application;

/**
 * Listener creating the guice injector
 */
public class M2lingGuiceServletContextListener extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		Injector injector = null;
		ServletModule module = new ServletModule() {
			@Override
			protected void configureServlets() {
				// We need to set widget set programmatically as the param-init is not read
				//  see http://code.google.com/p/google-guice/wiki/ServletRegexKeyMapping
				Map<String, String> params = new HashMap<String, String>();
				params.put("widgetset", "org.m2ling.presentation.widgetset.Org_m2ling_presentationWidgetset");
				// Servlet specific bindings, we serve '*', not only /* to also handle url without
				// trailing '/'
				serve("*").with(GuiceApplicationServlet.class, params);
				bind(Application.class).to(M2lingApplication.class);
				// Presentation layer bindings
				install(new PresentationCommonGuiceModule());
				install(new PresentationPrincipleGuiceModule());
				// Services layer bindings
				install(new ServicesCommonGuiceModule());
				// We bind this specific configuration to inject it directly at Conf instantiation.
				// This is required because the Guice.createInjector() could create the Conf singleton
				// then the Msg one before the register() method has a chance to be called. This would
				// cause an NPE in the Msg class lacking the Locale value.
				bind(SpecificConfiguration.class).annotatedWith(Names.named("bootstrap")).toInstance(
						new org.m2ling.presentation.principles.utils.SpecificConfiguration());
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
}
