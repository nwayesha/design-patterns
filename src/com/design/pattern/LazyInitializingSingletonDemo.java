package com.design.pattern;

public class LazyInitializingSingletonDemo {

	public static void main(String[] args) {
		
		/**
		 * Lazy Initialization
		 */
		SingletonLazyInitializing singletonIns = SingletonLazyInitializing.getSingletonInstance();
		System.out.println("singleton Ins  " + singletonIns.hashCode());
		SingletonLazyInitializing singletonIns2 = SingletonLazyInitializing.getSingletonInstance();
		System.out.println("singleton Ins2  " + singletonIns2.hashCode());
	}

}

class SingletonLazyInitializing{
	
	private static SingletonLazyInitializing singletonInstance;
	
	private SingletonLazyInitializing() {
		
	}
	
	public static SingletonLazyInitializing getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance = new SingletonLazyInitializing();
		}
		return singletonInstance;
	}
}
