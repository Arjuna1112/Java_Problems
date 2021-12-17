package com.multithreading.concurrencyimpl;

public class BoundedSemaphore {
	
	private int signalCount = 0;
	private int upperBound = 0;
	
	public BoundedSemaphore(int upperBound){
		this.upperBound=upperBound;
	}
	
	public synchronized void take() throws InterruptedException{
		while(this.signalCount==upperBound) wait();
		this.signalCount++;
		notify();
	}
	
	public synchronized void release() throws InterruptedException{
		while(this.signalCount==0) wait();
		this.signalCount--;
		notify();
	}

}
