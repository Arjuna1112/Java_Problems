package com.multithreading.concurrencyimpl;

import java.util.concurrent.Semaphore;

public class OddAndEvenPrintingBySemaphore implements Runnable{

	private boolean isEven;
	private int count;
	static Semaphore s = new Semaphore(1);
	static Semaphore t = new Semaphore(0);
	
	OddAndEvenPrintingBySemaphore(boolean flag, int c){
		isEven = flag;
		count = c;
	}
	
	@Override
	public void run() {
		if (isEven){
			try {
				printEven(count);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}else{
			try {
				printOdd(count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void printOdd(int count) throws InterruptedException{
		int c = 1;
		for(int i=0;i<count;i++){
			
			s.acquire(1);
			System.out.println(c);
			c = c+2;
			t.release(1);
			
		}
		
	}
	
	private void printEven(int count) throws InterruptedException{
		int c = 2;
		for(int i=0;i<count;i++){
			
			t.acquire(1);
			System.out.println(c);
			c = c+2;
			s.release(1);
		}
		
		
	}
	
	public static void main(String[] args){
		Thread a = new Thread(new OddAndEvenPrintingBySemaphore(true,20));
		Thread b = new Thread(new OddAndEvenPrintingBySemaphore(false,20));
		a.start();
		b.start();
					
	}
}

class Solution {
	private int upperLimit = 10;
	private int count =1;
	Semaphore semaphore = new Semaphore(1);

	public void printOdd(){
		while(count<upperLimit){
			synchronized (this){
				while (count<upperLimit && count%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(count+" ");
				count++;
				notify();
			}
		}
	}

	public void printEven(){
		while(count<upperLimit){
			synchronized (this){
				while (count<upperLimit && count%2==1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(count+" ");
				count++;
				notify();
			}
		}
	}

	public static void main(String args[]){
		Solution solution = new Solution();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				solution.printOdd();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				solution.printEven();
			}
		});
		t1.start();
		t2.start();
	}
}
