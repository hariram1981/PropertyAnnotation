/**
 * 
 */
package com.hariram.annotation.property;

import java.lang.reflect.Field;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.common.util.Util;

/**
 * @author hariram
 * date 19-Nov-2014
 */
public class PropertyAnnotationProcessor implements AnnotationProcessor {
	
	/**
	 * Default constructor
	 */
    public PropertyAnnotationProcessor() {
	}

    /**
	 * Process - call the db method with arguments provided, of the object passed that has the @DB
	 * 
	 * @param obj object which has @DB and the db method to be called using reflection
	 * @param callbackMethodName the db method to be called
	 * @param callbackMethodArgs arguments for the db method to be called
	 * @return Object that is returned by the db method
	 */
	public Object process(Object obj, String callbackMethodName, Object[] callbackMethodArgs) {
		Class objClass = obj.getClass();
		for(Field field: objClass.getFields()) {
			if(field.isAnnotationPresent(Property.class)) {
				Property property = field.getAnnotation(Property.class);
				String fileName = property.name();
				String filePath = property.path();
				String[] keys = property.keys();
				try {
					//Fetch from property file
					String value = Util.getProperty(filePath, fileName, keys[0]);
					field.set(obj, value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
