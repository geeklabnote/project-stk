package stk.web.gae.module;



import org.t2framework.t2.handler.ExceptionHandler;
import org.t2framework.t2.handler.impl.GlobalExceptionHandlerImpl;
import org.t2framework.t2.plugin.Plugin;

import stk.web.gae.handler.StkExceptionHandler;
import stk.web.gae.plugin.AuthPlugin;
import stk.web.gae.plugin.Slim3Plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ServletModule());
		install(new GaeServiceModule());
		install(new MobyletModule());
		install(new PageModule());
		bind(ExceptionHandler.class).annotatedWith(Names.named("exceptionHandler")).to(GlobalExceptionHandlerImpl.class).in(Scopes.SINGLETON);
		bind(ExceptionHandler.class).annotatedWith(Names.named("stkExceptionHandler")).to(StkExceptionHandler.class).in(Scopes.SINGLETON);
		bind(Plugin.class).annotatedWith(Names.named("authPlugin")).to(AuthPlugin.class).in(Scopes.SINGLETON);
		bind(Plugin.class).annotatedWith(Names.named("slim3Plugin")).to(Slim3Plugin.class).asEagerSingleton();
	}
}
