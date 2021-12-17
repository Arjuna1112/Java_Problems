package com.linkedList;

public class JReversLinkedlist {
	
	static Node head;
	
	
	public static void main(String[] args){
		
		JReversLinkedlist rever = new JReversLinkedlist();
		
		rever.head = new Node(5);
		rever.head.next = new Node(10);
		rever.head.next.next = new Node(15);
		rever.head.next.next.next = new Node(40);
		
		System.out.println("Input ..."+rever.printList());
		rever.reverseList();
		System.out.println("Output ..."+rever.printList());
		
	}
	
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}
	
	public String printList(){
		String output = "";
		Node curr = head;
		while(curr!=null){
			output = output+curr.data + "--->";
			curr = curr.next;
		}
		output=output+"TAIL";
		return output;
	}
	
	public void reverseList(){
		Node curr= head, rev=null;
		
		while(curr!=null){
			Node temp = curr.next;
			curr.next=rev;
			rev = curr;
			curr = temp;
		}
		
		head = rev;
	}
}