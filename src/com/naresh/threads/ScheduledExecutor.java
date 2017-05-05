package com.naresh.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {

	public static void main(String[] args) {

//		scheduledSingleExecution();
		scheduledFixedRateExecution();
		
	}
	
	private static void scheduledFixedRateExecution() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
		ScheduledFuture<?> future1 = executor.scheduleAtFixedRate(new ThreadNameRunnable("Future1", 500), 500, 500, TimeUnit.MILLISECONDS);
		ScheduledFuture<?> future2 = executor.scheduleAtFixedRate(new ThreadNameRunnable("Future2", 750), 500, 500, TimeUnit.MILLISECONDS);
		ScheduledFuture<?> future3 = executor.scheduleAtFixedRate(new ThreadNameRunnable("Future3", 1000), 500, 500, TimeUnit.MILLISECONDS);
		ScheduledFuture<?> future4 = executor.scheduleAtFixedRate(new ThreadNameRunnable("Future4", 1250), 500, 500, TimeUnit.MILLISECONDS);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		executor.shutdown();
		
		try {
			System.out.println("Future1" + future1.get());
			
			System.out.println("Future2" + future2.get());
			
			System.out.println("Future3" + future3.get());
			
			System.out.println("Future4" + future4.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void scheduledSingleExecution() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
		ScheduledFuture<String> future1 = executor.schedule(new ThreadNameCallable(500), 250, TimeUnit.MILLISECONDS);
		ScheduledFuture<String> future2 = executor.schedule(new ThreadNameCallable(750), 500, TimeUnit.MILLISECONDS);
		ScheduledFuture<String> future3 = executor.schedule(new ThreadNameCallable(1000), 750, TimeUnit.MILLISECONDS);
		ScheduledFuture<String> future4 = executor.schedule(new ThreadNameCallable(1250), 1000, TimeUnit.MILLISECONDS);
		
		executor.shutdown();
		
		try {
			while(!executor.awaitTermination(200, TimeUnit.MILLISECONDS)){
				System.out.println("Iteration");
				if(future1.isDone()){
					System.out.println("Future1" + future1.get());
				}
				
				if(future2.isDone()){
					System.out.println("Future2" + future2.get());
				}
				
				if(future3.isDone()){
					System.out.println("Future3" + future3.get());
				}
				
				if(future4.isDone()){
					System.out.println("Future4" + future4.get());
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
