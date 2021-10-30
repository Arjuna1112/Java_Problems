package com.multithreading.example;

public class OddAndEvenPrinting{
	private boolean isEven;
	
	static class EvenNoGen implements Runnable{
		int maxNo;
		private OddAndEvenPrinting printer;
		
		public EvenNoGen(int m, OddAndEvenPrinting p){
			this.maxNo=m;
			this.printer=p;
		}

		@Override
		public void run() {
			for(int i = 2;i<maxNo;i=i+2){
				try {
					printer.printEven(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}
		
	}
	
	static class OddNoGen implements Runnable{
		int maxNo;
		private OddAndEvenPrinting printer;
		
		public OddNoGen(int m, OddAndEvenPrinting p){
			this.maxNo=m;
			this.printer=p;
		}

		@Override
		public void run() {
			for(int i = 1;i<maxNo;i=i+2){
				try {
					printer.printOdd(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}
		
	}
	
	private void printEven(int i) throws InterruptedException{
		synchronized (this) {
			if(!isEven)
				wait();
				isEven = false;
				System.out.println(i);
				notify();	
		}
	}

	private void printOdd(int i) throws InterruptedException{
		synchronized (this) {
			if(isEven)
				wait();
				isEven = true;
				System.out.println(i);
				notify();
		}
	}
	
	public static void main(String args[]){
		int maxNo = 10;
		OddAndEvenPrinting p = new OddAndEvenPrinting();
		
		new Thread(new EvenNoGen(maxNo, p)).start();
		new Thread(new OddNoGen(maxNo, p)).start();
	}
}
