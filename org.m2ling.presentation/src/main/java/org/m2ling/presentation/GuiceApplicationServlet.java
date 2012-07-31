/**
 * Sample code from https://vaadin.com/wiki/-/wiki/Main/Integrating%20Vaadin%20with%20Guice%202.0?p_r_p_185834411_title=Integrating%2520Vaadin%2520with%2520Guice%25202.0 */
package org.m2ling.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

@SuppressWarnings("serial")
@Singleton
/**
 * The Guice servlet
 */
public class GuiceApplicationServlet extends AbstractApplicationServlet {
	protected final Provider<Application> applicationProvider;

	@Inject
	public GuiceApplicationServlet(Provider<Application> applicationProvider) {
		this.applicationProvider = applicationProvider;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getApplicationClass() throws ClassNotFoundException {
		return Application.class;
	}

	/**
	 * Called when using ?restartApplication argument in URL
	 */
	@Override
	protected Application getNewApplication(HttpServletRequest request) throws ServletException {
		return applicationProvider.get();
	}
}