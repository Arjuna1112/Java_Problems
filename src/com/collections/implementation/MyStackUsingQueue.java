package com.collections.implementation;

import java.util.concurrent.ArrayBlockingQueue;

public class MyStackUsingQueue {
	private static MyStackUsingQueue m = new MyStackUsingQueue();
	
	public static void main(String args[]){
		boolean usingTwoQueue = true;
		if(usingTwoQueue){
			for(int i = 1;i<4;i++){
				m.addUsingTwoQueue(i);
			}
			m.PrintStack();
			m.removeUsingTwoQueue();
			m.PrintStack();
			m.addUsingTwoQueue(6);
			m.PrintStack();
			m.removeUsingTwoQueue();
		}else{
			m.add(1);
			m.add(2);
			m.add(3);
			m.add(4);
			m.add(5);
			queue.printQueue();
			System.out.println(m.remove());
			System.out.println(m.remove());
			queue.printQueue();
		}
	}
	
	static MyQueue  queue = new MyQueue(10);
	int temp =0;
	
	public void add(Object O){
		temp++;
		queue.push(O);
	}
	
	public Object remove(){
		for(int i = 1; i<temp; i++){
			Object O = queue.pop();
			queue.push(O);
		}
		temp--;
		return queue.pop();
	}
	
	ArrayBlockingQueue<Object> q1 = new ArrayBlockingQueue<>(10);
	ArrayBlockingQueue<Object> q2 = new ArrayBlockingQueue<>(10);
	
	public void addUsingTwoQueue(Object O){
		if(q1.isEmpty()){
			q1.add(O);
			while(!q2.isEmpty()){
					q1.add(q2.remove());
			}
		}else if(q2.isEmpty()){
			q2.add(O);
			while(!q1.isEmpty()){
					q2.add(q1.remove());
			}
		}
	}
	
	public Object removeUsingTwoQueue(){
		if(q1.isEmpty()) return q2.remove();else return q1.remove();
	}

	public void PrintStack(){
		if(!q1.isEmpty()) {
			while (!q1.isEmpty()) System.out.println(q1.remove());
		}else {
			while (!q2.isEmpty()) System.out.println(q2.remove());
		}
	}
}
