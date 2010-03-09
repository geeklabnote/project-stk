package stk.web.gae.module;

import org.mobylet.core.Mobylet;
import org.mobylet.core.impl.MobyletImpl;

import com.google.inject.AbstractModule;

public class MobyletModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Mobylet.class).to(MobyletImpl.class);
	}

}
