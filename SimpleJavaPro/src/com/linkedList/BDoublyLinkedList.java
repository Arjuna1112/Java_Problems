package com.linkedList;



public class BDoublyLinkedList {
	
	private Node head;
	private int size;
	
	public BDoublyLinkedList()
	{
		this.head = null;
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
	
	public int getSize()
	{
		return size;
	}
	
	public void addFront(Object data)
	{
		if(head==null)
		{
			head=new Node(null,data,null);
		}
		else
		{
			Node newNode=new Node(null,data,head);
			head.previous=newNode;
			head=newNode;
		}
		size++;
	}
	
	public void removeFront()
	{
		if(head==null) return ;
		if(head.next==null)
		{
			head=null;
			size--;
			return;
		}
		head=head.next;
		head.previous=null;
		size--;
	}
	
	public void addRear(Object data)
	{
		if(head==null)
		{
			head=new Node(null,data,null);
		}else
		{
			Node current = head;
			while (current.next!=null)
			{
				current=current.next;
			}
			Node newNode=new Node(current,data,null);
			current.next=newNode;
		}
		size++;
	}
	
	public void removeRear()
	{
		if(head==null) return ;
		if(head.next==null)
		{
			head=null;
			size--;
			return;
		}
		Node current= head;
		while(current.next.next!=null)
		{
			current=current.next;
		}
		current.next=null;
		size--;
	}
	
	public void insertAt(Object data, int index)
	{
		if(index<1||index>size) return;
		Node current=head;
		int i=1;
		while(i<index)
		{
			current=current.next;
			i++;
		}
		if(current.previous==null)
		{
			Node newNode = new Node(null, data, current);
			current.previous=newNode;
			head=newNode;
			
		}
		else
		{
			Node newNode = new Node(current.previous,data,current);
			current.previous.next=newNode;
			current.previous=newNode;
		}
		size++;
	}
	
	public void removeAt(int index)
	{
		if(index<1||index>size)return;
		
		Node current = head;
		int i=1;
		while(i<index){
			current=current.next;
			i++;
		}
		if(current.next==null)
		{
			current.previous.next=null;
		}
		else if(current.previous==null){
			current = current.next;
			current.previous=null;
			head=current;
		}
		else{
			current.previous.next=current.next;
			current.next.previous=current.previous;
		}
		size--;	
	}
	
	private class Node
	{
		private Node next;
		private Node previous;
		private Object data;
		
		public Node(Node previous, Object data, Node next)
		{
			this.previous=previous;
			this.data=data;
			this.next=next;
		}
	}

}
