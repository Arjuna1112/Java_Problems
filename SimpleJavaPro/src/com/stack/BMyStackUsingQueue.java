package com.stack;

import com.queue.AMyQueue;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BMyStackUsingQueue {
	private static BMyStackUsingQueue m = new BMyStackUsingQueue();
	
	public static void main(String args[]){
		/*boolean usingTwoQueue = true;
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
		}*/

		m.push(1);
		m.push(2);
		m.push(3);
		m.push(4);
		m.push(5);
		m.print();
		m.pop();
		m.print();

		m.pushTwoQueue(1);
		m.pushTwoQueue(2);
		m.pushTwoQueue(3);
		m.pushTwoQueue(4);
		m.pushTwoQueue(5);
		m.printTwoQueue();
		m.popTwoQueue();
		m.printTwoQueue();
	}
	
	static AMyQueue queue = new AMyQueue(10);
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

	ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<Object>(100);
	int size = 0;

	public void push(Object o){
		arrayBlockingQueue.add(o);
		size++;
	}

	public void pop(){
		for(int i=1;i<size;i++)
			arrayBlockingQueue.add(arrayBlockingQueue.remove());
		arrayBlockingQueue.remove();
	}

	public void print(){
		System.out.println(arrayBlockingQueue);
	}

	ArrayBlockingQueue<Object> queue1 = new ArrayBlockingQueue<Object>(100);
	ArrayBlockingQueue<Object> queue2 = new ArrayBlockingQueue<Object>(100);

	public void pushTwoQueue(Object o){
		while(!queue1.isEmpty()) queue2.add(queue1.remove());
		queue1.add(o);
		while(!queue2.isEmpty()) queue1.add(queue2.remove());
	}

	public void popTwoQueue(){
		queue1.remove();
	}

	public void printTwoQueue(){
		System.out.println(queue1);
	}

	public void peek(){
		System.out.println(queue1.peek());
	}
}
