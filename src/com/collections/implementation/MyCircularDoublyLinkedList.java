package com.collections.implementation;

public class MyCircularDoublyLinkedList {
	
	private Node head;
	private Node dlList;
	int count;
	
	public MyCircularDoublyLinkedList() {
		count=0;
	}
	
	public void add(Object data)
	{
		Node newNode= new Node(data);
		
		if(count==0){
			dlList=newNode;
			dlList.previous=dlList;
			dlList.next=dlList;
			head=dlList;
		}
		else{
			newNode.previous=dlList.previous;
			newNode.next=dlList;
			dlList.previous.next=newNode;
			dlList.previous=newNode;
			head=dlList;
		}
		count++;
	}
	
	public void print(){
		if(count==0)return;
		Node current=head;
		do{
			System.out.println(current.data);
			current=current.next;
		}while(current!=head);
	}
	
	public void insert(Object data,int index){
		if(index>count)return;
		Node current=head;
		int i=0;
		while(i<index){
			i++;
			current=current.next;
		}
		Node newNode= new Node(data);
		current.previous.next=newNode;
		current.previous=newNode;
		newNode.previous=current.previous;
		newNode.next=current;
		count++;
	}
	
	public void delete(int index){
		if(index>count)return;
		Node current=head;
		int i=0;
		while(i<index){
			i++;
			current=current.next;
		}
		current.previous.next=current.next;
		current.next.previous=current.previous;
		count--;
	}
	private class Node {
		
		private Node next;
		private Node previous;
		Object data;
		
		public Node(Object data){
			this.data=data;
		}
		
	}

}
