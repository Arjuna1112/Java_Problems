package com.multithreading.example;

public class Synchronized_Example{
	
	public static void main(String args[]) throws InterruptedException{
		Synchronized_Example s = new Synchronized_Example();
		new Thread(new FiveMultiplier(s)).start();
		new Thread(new ThreeMultiplier(s)).start();
	}

	public synchronized void add(int n){
		for(int i=0;i<10;i++){
			System.out.println(i*n);
		}
	}

}

class
FiveMultiplier implements Runnable{

	private Synchronized_Example s;
	
	public FiveMultiplier(Synchronized_Example s) {
		this.s = s;
	}
	@Override
	public void run() {
		s.add(5);
	}
	
}

class ThreeMultiplier implements Runnable{

	private Synchronized_Example s;
	
	public ThreeMultiplier(Synchronized_Example s) {
		this.s = s;
	}
	@Override
	public void run() {
		s.add(3);
	}
	
}
