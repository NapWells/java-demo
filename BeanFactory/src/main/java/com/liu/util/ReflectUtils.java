package com.liu.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtils {

	public static void invokeSetterMethod(Object object, Field field, Object... args) {
        assert(object != null && field != null);

        try {
            Method method = getSetterMethodByField(field, object.getClass());
            method.invoke(object, args);
          
        } catch (SecurityException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException("Failed to invoke the setter method for field: "
                + field.getName());
        }
    }

    public static Method getSetterMethodByField(Field field, Class<?> clazz) {
        String fieldName = field.getName();
        
        StringBuilder sb = new StringBuilder(fieldName);
        if (Character.isLowerCase(fieldName.charAt(0))) {
            sb.setCharAt(0, Character.toUpperCase(fieldName.charAt(0)));
        }
        
        String setterMethodName = "set" + sb.toString();
        
        try {
            Method method = clazz.getMethod(setterMethodName, field.getType());
            return method;
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("No Setter method defined for field: " + field.getName()
                + ", the expected setter method is: " + setterMethodName);
        }
    }

}
