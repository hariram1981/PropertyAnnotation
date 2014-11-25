package com.hariram.annotation.property;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hariram.annotation.property.sample.SampleClass;
import com.hariram.annotation.property.sample.SampleStaticClass;

/**
 * Junit test case
 * 
 * @author hariram date 19-Nov-2014
 */
public class PropertyAnnotationTest {

	@Test
	public void test() {
		SampleClass sampleClass = new SampleClass();
		System.out.println(sampleClass.log4jroot);
		System.out.println(sampleClass.log4jStdOut);
		assertTrue(sampleClass.log4jroot != null
				&& !sampleClass.log4jroot.equals("")
				&& sampleClass.log4jroot != null
				&& !sampleClass.log4jroot.equals("")
				&& sampleClass.log4jStdOut != null
				&& !sampleClass.log4jStdOut.equals(""));
	}
	
	@Test
	public void testStatic() {
		SampleStaticClass.test();
		System.out.println(SampleStaticClass.log4jroot);
		System.out.println(SampleStaticClass.log4jStdOut);
		assertTrue(SampleStaticClass.log4jroot != null
				&& !SampleStaticClass.log4jroot.equals("")
				&& SampleStaticClass.log4jroot != null
				&& !SampleStaticClass.log4jroot.equals("")
				&& SampleStaticClass.log4jStdOut != null
				&& !SampleStaticClass.log4jStdOut.equals(""));
	}

}
