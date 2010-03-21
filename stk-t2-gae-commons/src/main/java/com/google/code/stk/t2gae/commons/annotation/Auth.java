package com.google.code.stk.t2gae.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE , ElementType.METHOD} )
public @interface Auth {
	public boolean onlyAdmin() default false;
	public boolean useGaeUser() default false;
}
