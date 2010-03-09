package stk.web.gae.module;

import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;

public class GaeServiceModule  extends AbstractModule{

	@Override
	protected void configure() {
		bind(URLFetchService.class).toProvider(new Provider<URLFetchService>(){
			@Override
			public URLFetchService get() {
				return URLFetchServiceFactory.getURLFetchService();
			}
		});

		bind(UserService.class).toProvider(new Provider<UserService>(){
			@Override
			public UserService get() {
				return UserServiceFactory.getUserService();
			}
		});
	}

}
