package com.naresh.threads;

public class JoinThread implements Runnable{

	private String name;
    private int sleepTime;
    private Thread waitsFor;
    
    JoinThread(String name, int stime, Thread wa) {
    	this.name = name;
    	this.sleepTime = stime;
    	this.waitsFor = wa;
    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("["+name+" ");

        try { Thread.sleep(sleepTime); }
        catch(InterruptedException ie) { }

        System.out.print(name+"? ");

        if (!(waitsFor == null))
        try { waitsFor.join(); }
        catch(InterruptedException ie) { }

        System.out.print(name+"] ");
	}

}
