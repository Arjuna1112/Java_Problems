package com.multithreading.example;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintingNumUsingMultiThread {
	
	public static void main(String[] args) {
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		Worker w3 = new Worker();
		
		w1.setNext(w2);
		w2.setNext(w3);
		w3.setNext(w1);
		
		Thread t1 = new Thread(w1,"Worker Thread 1");
		Thread t2 = new Thread(w2,"Worker Thread 2");
		Thread t3 = new Thread(w3,"Worker Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		
		w1.accept(1);
	}
	
}

class Worker implements Runnable{
	
	LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
	private Worker next;
	
	public void setNext(Worker w) {
		this.next=w;
	}
	
	public void accept(int i){
		q.add(i);
	}

	@Override
	public void run() {
		while(true){
			try {
				int i = q.take();
				System.out.println(Thread.currentThread().getName()+" Printing "+i);
				Thread.sleep(1000);
				if(next!=null)
					next.accept(i+1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}

