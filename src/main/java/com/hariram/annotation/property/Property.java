/**
 * 
 */
package com.hariram.annotation.property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
/**
 * Annotation for Property files
 * 
 * @author hariram
 * date 19-Nov-2014
 */
@Target({ElementType.FIELD})
public @interface Property {
	String path();
	String name();
	String[] keys();
}
