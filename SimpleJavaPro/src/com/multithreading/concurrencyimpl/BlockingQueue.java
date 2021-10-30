package com.multithreading.concurrencyimpl;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	
	private List<Object> queue = new LinkedList<Object>();
	private int limit = 10;
	
	public BlockingQueue(int limit){
		this.limit=limit;
	}
	
	public synchronized void enqueue(Object data) throws InterruptedException{
		while(this.queue.size()==this.limit){
			wait();
		}
		if(this.queue.size()==0){
			notifyAll();
		}
		queue.add(data);
	}
	
	public synchronized void dequeue(Object data) throws InterruptedException{
		while(this.queue.size()==0){
			wait();
		}
		if(this.queue.size()==this.limit){
			notifyAll();
		}
		queue.remove(data);
	}

}
