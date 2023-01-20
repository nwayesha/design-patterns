package com.design.pattern;

public class EagerInitializingSingletonDemo {

	/**
	 * Eager Initialization
	 */
	public static void main(String[] args) {
		EagerInitializingSingleton singletonIns = EagerInitializingSingleton.getEagerInitializingSingletonInstance();
		System.out.println("Eager initialing singleton Ins  " + singletonIns.hashCode());
		EagerInitializingSingleton singletonIns2 = EagerInitializingSingleton.getEagerInitializingSingletonInstance();
		System.out.println("Eager initialing singleton Ins2  " + singletonIns2.hashCode());
	}

}

class EagerInitializingSingleton{
	
	private static final EagerInitializingSingleton instance = new EagerInitializingSingleton();
	
	private EagerInitializingSingleton() {
		
	}
	
	public static EagerInitializingSingleton getEagerInitializingSingletonInstance() {
		
		return instance;
	}
}