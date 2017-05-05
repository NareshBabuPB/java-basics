package com.naresh.threads;

import java.util.concurrent.Callable;

public class ThreadNameCallable implements Callable<String> {
	
	public ThreadNameCallable(long waitTime) {
		super();
		this.waitTime = waitTime;
	}

	long waitTime;

	@Override
	public String call() throws Exception {

		Thread.sleep(waitTime);
		
		return Thread.currentThread().getName();
	}

}
