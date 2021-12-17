package com.queue;

import java.util.*;

public class BMyQueueUsingStack {
	
	public static void main(String args[]){
		BMyQueueUsingStack m = new BMyQueueUsingStack();
		for(int i = 1;i<4;i++){
			m.addUsingTwoStack(i);
		}
		m.printQueue();
		/*m.removeUsingTwoStack();
		m.printQueue();
		m.addUsingTwoStack(6);
		m.printQueue();
		m.removeUsingTwoStack();*/
	}

	
	Stack<Object> s1 = new Stack<>();
	Stack<Object> s2 = new Stack<>();

	//s1 - 1
	//s2 -
	//s1 -
	private void addUsingTwoStack(Object data){
		while (!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(data);
		while (!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}
	
	private void removeUsingTwoStack(){
		if(!s1.isEmpty()) s1.pop();
	}
	
	private void printQueue(){
		if(!s1.isEmpty()){
			while(!s1.isEmpty()){
				System.out.println(s1.pop());
			}
		}
	}

	class Queue{

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		public void enqueue(int data){
			while(!s1.isEmpty()) s2.push(s1.pop());
			s1.push(data);
			while(!s2.isEmpty()) s1.push(s2.pop());
		}

		public void dequeue(){
			s1.pop();
		}

		public void print(){
			System.out.println(s1);
		}

	}
}


