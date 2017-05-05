package com.naresh.threads;

public class MethodSynchronization {

	private int counter = 1;
	private int multiple;
	
	public MethodSynchronization(int multiple) {
		this.multiple = multiple;
	}
	
	public synchronized void increment(){
		int multiplier = this.counter;
		int multiplicand = this.multiple;
		System.out.println("Before Increment: " + multiplier);
		
		int result = multiplicand * multiplier;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.counter = result;
		
		System.out.println("After Increment: " + this.counter);
	}
	
	public synchronized void reset(){
		int currentValue = this.counter;
		System.out.println("Before Reset: " + currentValue);
		if(currentValue > 1000){
			this.counter = 1;
		}
		
		System.out.println("After Reset: " + this.counter);
	}
	
	public synchronized int get(){
		return this.counter;
	}
}
