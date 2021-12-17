package com.collections.implementation;

import java.util.*;

public class MyQueueUsingStack {
	
	public static void main(String args[]){
		MyQueueUsingStack m = new MyQueueUsingStack();
		boolean usingTwoQueue = true;
		if(usingTwoQueue){
			for(int i = 1;i<4;i++){
				m.addUsingTwoStack(i);
			}
			m.printQueue();
			/*m.removeUsingTwoStack();
			m.printQueue();
			m.addUsingTwoStack(6);
			m.printQueue();
			m.removeUsingTwoStack();*/
		}else{
			/*m.push(1);
			m.push(2);
			m.push(3);
			m.push(4);
			m.push(5);
			System.out.println(m.pop());*/
		}
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
}
