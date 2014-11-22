/**
 * 
 */
package com.hariram.annotation.property;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.common.util.Util;

/**
 * @author hariram
 * date 19-Nov-2014
 */
public class PropertyAnnotationProcessor implements AnnotationProcessor {
	
	public static final Logger LOGGER = Logger.getLogger(PropertyAnnotationProcessor.class);
	
	/**
	 * Default constructor
	 */
    public PropertyAnnotationProcessor() {
	}

    /**
	 * Process - call the callback method with arguments provided, of the object passed that has the @Property
	 * - not used method
	 * 
	 * @param obj object which has @Property and the method to be called using reflection
	 * @param callbackMethodName the method to be called
	 * @param callbackMethodArgs arguments for the method to be called
	 * @return Object that is returned by the method
	 * @deprecated - not used method in property annotation
	 */
	public Object process(Object obj, String callbackMethodName, Object[] callbackMethodArgs) {
		return null;
	}

    /**
	 * Process - call the callback method with arguments provided, of the object passed that has the @Property
	 * 
	 * @param obj object which has @Property and the method to be called using reflection
	 * @return Object that is returned by the db method
	 */
	public Object process(Object obj) {
		LOGGER.info("PropertyAnnotationProcessor.process, obj : " + obj);
		Class<? extends Object> objClass = obj.getClass();
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
					LOGGER.error("Util.process IllegalArgument or IllegalAccessException, message : " + e.getClass() + " " + e.getMessage());
				}
			}
		}
		LOGGER.info("PropertyAnnotationProcessor.process, processing done");
		return null;
	}

}
