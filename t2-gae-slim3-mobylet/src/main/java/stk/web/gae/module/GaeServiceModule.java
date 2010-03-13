package stk.web.gae.module;

import stk.web.gae.service.UserServiceImpl;

import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.name.Names;

public class GaeServiceModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(URLFetchService.class).toProvider(new Provider<URLFetchService>(){
			@Override
			public URLFetchService get() {
				return URLFetchServiceFactory.getURLFetchService();
			}
		});

		bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
		bind(UserService.class).annotatedWith(Names.named("gae")).toProvider(new Provider<UserService>() {

			@Override
			public UserService get() {
				return UserServiceFactory.getUserService();
			}

		});
	}

}
