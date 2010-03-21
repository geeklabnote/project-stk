package com.google.code.stk.t2gae.commons.adapter;

import java.util.List;

import org.t2framework.commons.exception.NoSuchComponentException;
import org.t2framework.commons.util.Assertion;
import org.t2framework.commons.util.CollectionsUtil;
import org.t2framework.t2.adapter.GuiceAdapter;
import org.t2framework.t2.handler.ExceptionHandler;

import com.google.inject.Binding;
import com.google.inject.TypeLiteral;

public class StkGuiceAdapter extends GuiceAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getComponents(Class<? super T> componentClass) {
		Assertion.notNull(componentClass);
		setupInjector();
		List<T> ret = CollectionsUtil.newArrayList();
		for (Object binding : injector.findBindingsByType(TypeLiteral
				.get(componentClass))) {
			ret.add((T) injector.getInstance(((Binding<T>) binding).getKey()));
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getComponent(Class<? super T> componentClass) {
		Assertion.notNull(componentClass);
		setupInjector();
		try {
			if (hasComponent(componentClass)) {
				List<?> findBindingsByType = injector
						.findBindingsByType(TypeLiteral.get(componentClass));
				for (Object binding : findBindingsByType) {
					return (T) injector.getInstance(((Binding<T>) binding)
							.getKey());
				}
			}
			return null;
		} catch (Throwable e) {
			throw new NoSuchComponentException(componentClass);
		}
	}

	@Override
	public <T> boolean hasComponent(Class<T> componentClass) {
		try {
			return !injector
					.findBindingsByType(TypeLiteral.get(componentClass))
					.isEmpty();
		} catch (Throwable t) {
			return false;
		}
	}

	@Override
	public List<ExceptionHandler<Throwable, Exception>> createExceptionHandlers() {
		try {
			return this.getComponents(ExceptionHandler.class);
		} catch (Throwable t) {
			return CollectionsUtil.emptyList();
		}
	};
}
