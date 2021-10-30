package com.multithreading.concurrencyimpl;

public class Lock {
	
	public boolean isLocked=false;
	Thread lockedBy = null;
	int lockedCount = 0;
	
	public synchronized void lock() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		while(isLocked && callingThread!=lockedBy){
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = callingThread;
	}
	
	public synchronized void unlock(){
		if(Thread.currentThread()==lockedBy)
			lockedCount--;
		if(lockedCount==0){
			isLocked=false;
			notify();	
		}
	}

}
