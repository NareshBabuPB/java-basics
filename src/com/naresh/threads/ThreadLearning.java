package com.naresh.threads;

public class ThreadLearning {

	public static void main(String[] args) {
		
		/**
		 * Preemptive scheduling - Highest priority thread always wins
		 * Time slicing - Each thread gets fixed time slice. Priority is checked before allocating time, will not be interrupted between
		 * 
		 * Daemon Threads - Threads that serves user threads, like gc, finalizer etc.
		 * 		User thread cannot be converted to Daemon thread. - IllegalThreadStateException
		 * 
		 * Synchronization - To avoid Thread interference and memory consistency errors
		 * 			Slows down some execution, as it blocks threads
		 * 
		 * 			Every object has intrinsic lock or monitor lock
		 * 			Method synchronization takes Method's object as lock - Instance on which method is invoked
		 * 			Static block synchronization takes lock on that Class object.
		 * 
		 *   		Reentrant Synchronization - A thread acquires lock it already owns
		 *   
		 *   Happens Before relationship
		 *   		Talks about visibility of the changes to shared resources between threads
		 *   		Synchronized methods and blocks ensures the memory is flushed once it completes. Changes written to main memory.
		 *   		join() - technique to enforce Happens Before 
		 *   
		 *   
		 *   Immutable objects
		 *   	Benefits in multi-threaded application. 
		 *   	Since such object state cannot be changed, sharing across threads will NOT result in inconsistent state
		 *   	Statements access such object's state need not be within synchronized block either, which blocks threads
		 */
//		testJoin();
		
		//Wait
		//Notify
//		testWait();
		
		//Interrupt
//		testInterrupt();
		//currentThread
		//ThreadGroup
		//yield
		
		testMethodSync();
	}
	
	private static void testMethodSync(){
		final MethodSynchronization methodSync = new MethodSynchronization(50);
		
		Runnable increment = new Runnable(){

			@Override
			public void run() {
				System.out.println("Thread Started:" + Thread.currentThread().getName());
				while (methodSync.get() < 5000) {
					methodSync.increment();
				}
			}
			
		};
		
		Runnable reset = new Runnable(){

			@Override
			public void run() {
				System.out.println("Thread Started:" + Thread.currentThread().getName());
				while (methodSync.get() < 5000) {
					methodSync.reset();
				}
			}
			
		};
		
		Thread threadA = new Thread(increment, "Thread-A");
		Thread threadB = new Thread(reset, "Thread-B");
		
		threadA.start();
//		threadB.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (methodSync.get() < 5000) {
			System.out.println("Waiting for methodSync...");
			// Below block cannot execute unless Thread-A increment method completes
			//     As both monitors methodSync lock
			synchronized (methodSync) {
				methodSync.reset();
			}
		}
	}
	
	
	private static void testInterrupt(){
		// IllegalMonitorStateException - when a thread invokes wait() or notify() on an object which it doesn't own.
		
		
		final Thread displayThread = new Thread(new Runnable(){

			@Override
			public void run() {
				while(!Thread.interrupted()){  // Resets status. Always works on Current Thread
					System.out.println("Still alive..");
				}
				System.out.println("Display Thread Dying now.." + Thread.currentThread().isInterrupted());  // Doesn't reset status.
				System.out.println("Display Thread interrupted().." + Thread.interrupted());
				System.out.println("Display Thread after interrupted().." + Thread.currentThread().isInterrupted());
				System.out.println("Display Thread interrupted().." + Thread.interrupted());
			}
			
		});
		
		displayThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			System.out.println("Parrent Thread interrupted..");
			e1.printStackTrace();
		}
		
		displayThread.interrupt();
		
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			System.out.println("Parrent Thread interrupted..");
			e1.printStackTrace();
		}*/
		
		System.out.println("Display Thread in Parent.." + displayThread.isInterrupted());
		
		System.out.println("Parent Thread Dying now.." + Thread.currentThread().isInterrupted());
		
	}
	
	
	private static void testWait(){
		// IllegalMonitorStateException - when a thread invokes wait() or notify() on an object which it doesn't own.
		
		final Producer producer = new Producer();
		final Consumer consumer = new Consumer();
		
		Thread produceThread = new Thread(new Runnable(){
			String[] products = {"cabbage", "carrot", "pineapple", "mango"};

			@Override
			public void run() {

				for(String product : products){
					System.out.println("ProducerThread: before synch block");
					synchronized(producer){
						System.out.println("ProducerThread: synch block");
						producer.put(product);
						System.out.println("ProducerThread: before notify");
						producer.notify();
						System.out.println("ProducerThread: after notify");
					}
				}
				
			}
			
		});
		
		Thread consumeThread = new Thread(new Runnable(){

			@Override
			public void run() {
				while (consumer.size() < 4) {
					
					synchronized (producer) {
						System.out.println("ConsumerThread: synch block");
						if (producer.isEmpty()) {
							System.out.println("ConsumerThread: isEmpty check");
							try {
								producer.wait();
								System.out.println("ConsumerThread: after wait");
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					synchronized (consumer) {
						System.out.println("ConsumerThread: updating consumer");
						consumer.put(producer.get());
						consumer.notify();
					}
				}
			}
		});
		
		Thread displayThread = new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					synchronized (consumer) {
						consumer.display();
						if(consumer.size() == 4)
							break;
						
						try {
							consumer.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
			
		});
		
		
		displayThread.start();
		consumeThread.start();
		produceThread.start();
	}

	private static void testThread() {
//		IllegalThreadStateException - When you start a thread, which is already executed. 
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread T");
			}
			
		});
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread T1");
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread T2");
			}
			
		});
		
//		pub.run();
		t.start();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		t2.start();
	}
	
	private static void testJoin(){
		Thread t1 = new Thread(new JoinThread("1",0,null));
        Thread t2 = new Thread(new JoinThread("2",0,t1));
        Thread t3 = new Thread(new JoinThread("3",0,t2));
        Thread t4 = new Thread(new JoinThread("4",0,t1));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
	}

}
