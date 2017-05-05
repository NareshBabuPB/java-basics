package com.naresh.threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronizedQueue {

	public static void main(String[] args) {
		 /*SynchronousQueue - Has synchronized methods to operate on a Queue.
		 	put & take blocks threads unless Queue is empty or not.
		 	
		 	
		 	*/
		
		final BlockingQueue<Integer> queue = new SynchronousQueue<Integer>();

		Runnable producer = new Runnable(){

			@Override
			public void run() {
				try {
					while (true) {
						Integer nextInt = new Random().nextInt(1000);
						System.out.println(Thread.currentThread().getName() + " producing... " +  nextInt);
						queue.put(nextInt);
						System.out.println(Thread.currentThread().getName() + " produced... " +  nextInt);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		
		Runnable consumer = new Runnable(){

			@Override
			public void run() {
				try {
					while (true) {
						System.out.println(Thread.currentThread().getName() +  " consuming... ");
						Thread.sleep(500);
						Integer availableInt = queue.take();
						System.out.println(Thread.currentThread().getName() +  " consumed... " + availableInt);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		
		Thread threadP = new Thread(producer, "Thread-P");
		Thread threadC1 = new Thread(consumer, "Thread-C1");
		Thread threadC2 = new Thread(consumer, "Thread-C2");
		
		System.out.println("Starting... ");
		
		threadP.start();
		threadC1.start();
		threadC2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		threadP.interrupt();
		threadC1.interrupt();
		threadC2.interrupt();
	}

}
