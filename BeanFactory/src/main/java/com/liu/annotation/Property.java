package com.liu.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Property {
	 public static enum PropertyType {
		 	Byte,
	        Short,
	        Integer,
	        Long,
	        Float,
	        Double,
	        Character,
	        Boolean,
	        String
	    }
	String value();
	PropertyType type();
}
