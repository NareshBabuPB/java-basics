package com.naresh.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		FutureTask<String> future1 = new FutureTask<String>(new ThreadNameCallable(200));
		FutureTask future2 = new FutureTask(new ThreadNameCallable(1000));
		FutureTask future3 = new FutureTask(new ThreadNameCallable(600));
		FutureTask future4 = new FutureTask(new ThreadNameCallable(800));

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future<String> future1 = executor.submit(new ThreadNameCallable(200));
		// executor.execute(new ThreadNameCallable(300));  // NOT ALLOWED - execute() accepts only Runnable
		executor.execute(future2);  // Accepts FutureTask, as it implements RunnableFutute 
		executor.execute(future3);  
		executor.execute(future4);
		
		
		while (!(future3.isDone() && future4.isDone())) {
			if (future1.isDone()) {
				try {
					System.out.println(future1.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				System.out.println(future2.get(200, TimeUnit.MILLISECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		executor.shutdown();
	}

}
