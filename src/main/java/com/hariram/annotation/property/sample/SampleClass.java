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
public class SampleClass {
	
	public static final Logger LOGGER = Logger.getLogger(SampleClass.class);
	
	@Property(
			path="/home/hariram/Personal/github/PropertyAnnotation/src/main/resources/",
			name="log4j", 
			keys={"log4j.rootLogger"})
	public String log4jroot;
	
	@Property(
			path="/home/hariram/Personal/github/PropertyAnnotation/src/main/resources/",
			name="log4j", 
			keys={"log4j.appender.stdout"})
	public String log4jStdOut;
	
	/**
	 * Default constructor
	 */
	public SampleClass() {
		LOGGER.info("SampleClass.constructor - start calling PropertyAnnotationProcessor");
		AnnotationProcessor processor = new PropertyAnnotationProcessor();
		processor.process(this, null, null);
		LOGGER.info("SampleClass.constructor - done calling PropertyAnnotationProcessor");
	}
	
}
