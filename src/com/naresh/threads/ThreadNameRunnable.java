package com.naresh.threads;

public class ThreadNameRunnable implements Runnable {
	long waitTime;
	String name;
	
	public ThreadNameRunnable(String runnableName, long waitTime) {
		super();
		this.waitTime = waitTime;
		this.name = runnableName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + name + " starting...");
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " " + name + " completed...");
	}

}
