package com.hariram.annotation.property.sample;

import org.apache.log4j.Logger;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.annotation.property.Property;
import com.hariram.annotation.property.PropertyAnnotationProcessor;

/**
 * Sample class for @Property annotation
 * 
 * @author hariram
 * date 18-Nov-2014
 */
public class SampleStaticClass {
	
	public static final Logger LOGGER = Logger.getLogger(SampleStaticClass.class);
	
	@Property(
			path="/home/hariram/Personal/github/PropertyAnnotation/src/main/resources/",
			name="log4j", 
			keys={"log4j.rootLogger"})
	public static String log4jroot;
	
	@Property(
			path="/home/hariram/Personal/github/PropertyAnnotation/src/main/resources/",
			name="log4j", 
			keys={"log4j.appender.stdout"})
	public static String log4jStdOut;
	
	static {
		LOGGER.info("SampleClass.constructor - start calling PropertyAnnotationProcessor");
		AnnotationProcessor processor = new PropertyAnnotationProcessor();
		processor.process(new SampleStaticClass());
		LOGGER.info("SampleClass.constructor - done calling PropertyAnnotationProcessor");
	}
	
	public static void test() {
		System.out.println("in static method");
	}
	
}
