PropertyAnnotation
==================

- Adds annotation for property file operations.
- @Property (path="", name="", keys={""}).
- Annotation is set for variables in the class. 

Interfaces
----------
###1. com.hariram.annotation.property.Property 
 - Interface for the annotation - @Property.
 - Has parameters of String path, String name and String[] keys 
 
Classes
----------
###1. com.hariram.annotation.property.PropertyAnnotationProcessor
 - Class that processes the @Property annotation.
 - Implements com.hariram.annotation.AnnotationProcessor. 
 
####Object process(Object obj)
 - Processes the annotation and sets the class level variables which have been annotated by @Property.
 
###2. com.hariram.annotation.AnnotationException
 - Exception that extends RuntimeException and handles exceptions related to annotations
 
Usage
----------
- In the class where value from key in property file is to be set, @Property annotation has to be set as below:

		@Property(
			path="/opt",
			name="log4j", 
			keys={"log4j.appender.stdout"})
		public String log4jroot;
		
- In above first two line sets the value of the key log4j.appender.stdout from /opt/log4j.properties to log4jroot variable.

- The below code has to be set either in static block for static variables or in constructor for class variables:

		AnnotationProcessor processor = new PropertyAnnotationProcessor();
		processor.process(<class instance[this,new <classname>()>);
		//processor.process(this) - for class variables and called in MyClass()
		//processor.process(new MyClass() - for static variables of MyClass


License
==========
Copyright (c) 2014 GitHub, Inc. See the LICENSE file for license rights and limitations (GNU GPL v2.0)