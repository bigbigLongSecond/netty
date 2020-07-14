package com.annotation;

import com.test.TestAnnoationChild;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnnotation {
    public static void getAnnotation() throws ClassNotFoundException {
    	Class  clazz = Class.forName("com.test.TestAnnoationChild");
    	Annotation[]  annotations = clazz.getAnnotations();
    	for (Annotation annotation : annotations) {
			if (annotation instanceof TestA) {
				System.out.println("8888");
				TestA  a = (TestA) annotation;
				System.out.println("method:" + a.methodName() + "   param:" + a.paramInfo());
			}
		}
    }

	public static void parseMethodAnnotation() {
		Method[] methods = TestAnnoationChild.class.getDeclaredMethods();
		for (Method method : methods) {

			boolean hasAnnotation = method.isAnnotationPresent(TestA.class);
			if (hasAnnotation) {
				TestA annotation = method.getAnnotation(TestA.class);
				System.out.println("method:" + annotation.methodName() + "   param:" + annotation.paramInfo());
			}
		}
	}
	
    public static void main(String[] args)  {
    	try {
			getAnnotation();parseMethodAnnotation();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
