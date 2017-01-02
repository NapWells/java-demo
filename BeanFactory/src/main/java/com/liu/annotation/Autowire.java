package com.liu.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Autowire {
	   public static enum AutowiredType {
	        BY_NAME,
	        BY_CLASS
	    }
	    AutowiredType type() default AutowiredType.BY_NAME;
}
