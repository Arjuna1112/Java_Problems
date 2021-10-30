package com.multithreading.example;

import java.util.ArrayList;
import java.util.List;

public class Producer_Consumer_Pro {
	
	List<Integer> l = new ArrayList<Integer>();
	int threshold = 10;
	
	
	public static void main(String args[]){
		Producer_Consumer_Pro p = new Producer_Consumer_Pro();
		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}
	
	public synchronized void add() throws InterruptedException{
		int i=0;
		if(l.size()==threshold) wait();
		l.add(i);
		System.out.println("Adding ..."+i);
		notifyAll();
		i++;
	}
	
	public synchronized void remove() throws InterruptedException{
		if(l.size()==0) wait();
		int i = l.remove(0);
		System.out.println("Removing ..."+i);
		notifyAll();
	}

}

class Producer implements Runnable{

	private Producer_Consumer_Pro p;
	
	public Producer(Producer_Consumer_Pro p) {
		this.p = p;
	}
	@Override
	public void run() {
		try {
			while(true){
				p.add();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Consumer implements Runnable{

	private Producer_Consumer_Pro p;
	
	public Consumer(Producer_Consumer_Pro p){
		this.p = p;
	}
	@Override
	public void run() {
		try {
			p.remove();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
