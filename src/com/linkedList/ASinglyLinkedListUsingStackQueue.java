package com.linkedList;

public class ASinglyLinkedListUsingStackQueue {
	
	private Node head;
	private int size;
	
	public ASinglyLinkedListUsingStackQueue()
	{
		this.head=null;
	}
	
	public void insertAsStack(Object data)
	{
		Node node = new Node (data);
		node.next=head;
		head=node;
		size++;
	}
	
	public void insertAsQueue(Object data)
	{
		Node node = new Node (data);
		if(head==null)
		{
			node.next=head;
			head=node;
			return;
		}
		Node current = head;
		while(current.next!=null){
			current=current.next;
		}
		current.next=node;
		size++;
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
	public boolean deleteAsStack()
	{
		if(head==null)return false;
		head=head.next;
		size--;
		return true;
	}
	
	public boolean deleteAsQueue(){
		if(head==null)return false;
		head=head.next;
		size--;
		return true;
	}
	
	public void print()
	{
		Node current = head;
		while(current!=null)
		{
			System.out.println(current.data);
			current=current.next;
		}
	}
	public int getSize(){
		return size;
	}
	
	private class Node 
	{
		private Object data;
		private Node next;
		
		public Node(Object data)
		{
			this.data=data;
		}
	}

}
