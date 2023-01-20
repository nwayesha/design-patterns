package com.design.pattern;

public class StaticBlockSingletonDemo {
	/**
	 * static block Initialization
	 */
	public static void main(String[] args) {
		StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getStaticBlockSingleton();
		System.out.println("static block initialing singleton Ins  " + staticBlockSingleton.hashCode());
		StaticBlockSingleton singletonIns2 = StaticBlockSingleton.getStaticBlockSingleton();
		System.out.println("static block initialing singleton Ins2  " + singletonIns2.hashCode());
	}
}

class StaticBlockSingleton{
	
	private static StaticBlockSingleton instance;
	
	private StaticBlockSingleton() {
		
	}
	static {
		try {
			instance = new StaticBlockSingleton();
			
		}catch(Exception e) {
			throw new RuntimeException("Exception occurred in creating static block initializing singleton pattern..");
		}
	}
	
	public static StaticBlockSingleton  getStaticBlockSingleton() {
		return instance;
	}
}