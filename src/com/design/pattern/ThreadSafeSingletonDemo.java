package com.design.pattern;

public class ThreadSafeSingletonDemo {

	/**
	 * Thread safe singleton
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getThreadSafeSingleton();
		System.out.println("static block initialing singleton Ins  " + threadSafeSingleton.hashCode());
		ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getThreadSafeSingleton();
		System.out.println("static block initialing singleton Ins2  " + threadSafeSingleton2.hashCode());

		ThreadA thread = new ThreadA();
		thread.run();
		thread.sleep(1000);
		ThreadB threadb = new ThreadB();
		threadb.run();
	}

}

class ThreadSafeSingleton{
	/**
	 * This will have performance issues.
	 */
	private static ThreadSafeSingleton threadSafeSingleton ;
	
	private ThreadSafeSingleton() {
		
	}
	public static synchronized ThreadSafeSingleton getThreadSafeSingleton() {
		if(threadSafeSingleton == null) {
			threadSafeSingleton = new ThreadSafeSingleton();
		}
		return threadSafeSingleton;
	}
}

class DoubleLockingSingleton{
	
	private static DoubleLockingSingleton doubleLockingSingleton;
	
	private DoubleLockingSingleton() {
		
	}
	
	public static DoubleLockingSingleton getDoubleLockingSingleton() {
		if(doubleLockingSingleton == null) {
			synchronized (DoubleLockingSingleton.class) {
				if(doubleLockingSingleton == null) {
					doubleLockingSingleton = new DoubleLockingSingleton();
				}
			}
			
		}
		return doubleLockingSingleton;
	}
}

class ThreadA extends Thread{
	public void run() {
		System.out.println("Thread A class :: " + ThreadSafeSingleton.getThreadSafeSingleton().hashCode());
		System.out.println("Thread A double locking :: " + DoubleLockingSingleton.getDoubleLockingSingleton().hashCode());
	}
}

class ThreadB extends Thread{
	public void run() {
		System.out.println("Thread B class :: " + ThreadSafeSingleton.getThreadSafeSingleton().hashCode());
		System.out.println("Thread B double locking :: " + DoubleLockingSingleton.getDoubleLockingSingleton().hashCode());
	}
}