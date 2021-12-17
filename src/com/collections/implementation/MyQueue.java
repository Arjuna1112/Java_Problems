package com.collections.implementation;

public class MyQueue {
	
	int size;
	Object[] myQueue;
	int queueMaxSize = 10;
	
	public MyQueue(int d){
		myQueue= new Object[queueMaxSize];
	}
	
	public void push(Object data){
		if(size>=queueMaxSize) resizeArray();
		myQueue[size] = data;
		size++;
	}
	
	public Object pop(){
		if(size==0) return null;
		Object temp=myQueue[0];
		for(int i = 1; i<size; i++){
			myQueue[i-1]=myQueue[i];
		}
		size--;
		return temp;
	}
	
	public Object front(){
		return myQueue[size-1];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void resizeArray(){
		Object[] temp=myQueue;
		queueMaxSize = queueMaxSize*2;
		myQueue = new Object[queueMaxSize];
		for(int i = 0; i<size; i++){
			myQueue[i]=temp[i];
		}
	}

	public void printQueue() {
		// TODO Auto-generated method stub
		while (size>0)System.out.println(pop());
	}

}
