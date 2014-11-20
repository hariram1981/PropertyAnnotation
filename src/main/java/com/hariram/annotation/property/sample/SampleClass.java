package com.hariram.annotation.property.sample;

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
		AnnotationProcessor processor = new PropertyAnnotationProcessor();
		processor.process(this, null, null);
	}
	
	/**
	 * main function
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SampleClass sampleClass = new SampleClass();
		System.out.println(sampleClass.log4jroot);
		System.out.println(sampleClass.log4jStdOut);
	}
}
