package com.design.pattern;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
	   public static void main(String[] args) {
		   EagerInitializingSingleton instanceOne = EagerInitializingSingleton.getEagerInitializingSingletonInstance();
		   EagerInitializingSingleton instanceTwo = null;
	        try {
	            Constructor[] constructors = EagerInitializingSingleton.class.getDeclaredConstructors();
	            for (Constructor constructor : constructors) {
	                // This code will destroy the singleton pattern
	                constructor.setAccessible(true);
	                instanceTwo = (EagerInitializingSingleton) constructor.newInstance();
	                break;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println("reflection >>" + instanceOne.hashCode());
	        System.out.println(instanceTwo.hashCode());
	    }
}
