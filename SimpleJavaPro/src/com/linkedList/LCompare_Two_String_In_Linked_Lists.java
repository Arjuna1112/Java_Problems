package com.linkedList;

public class LCompare_Two_String_In_Linked_Lists {

	/*Given two linked lists, represented as linked lists (every character is a node in linked list). Write a function compare() that works similar to strcmp(), i.e., it returns 0 if both strings are same, 
	 * 1 if first linked list is lexicographically greater, and -1 if second string is lexicographically greater.
	Examples:
	Input: list1 = g->e->e->k->s->a
	       list2 = g->e->e->k->s->b
	Output: -1
	Input: list1 = g->e->e->k->s->a
	       list2 = g->e->e->k->s
	Output: 1
	Input: list1 = g->e->e->k->s
	       list2 = g->e->e->k->s
	Output: 0*/
	
	Node head;
	static Node a, b;
	
	static class Node {
		char data;
		Node next;
		Node(char d){
			data = d;
			next = null;
		}
	}
	
	void printList(Node node){
		while(node != null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	int compare(Node a, Node b){
		if(a == null && b == null){
			return 1;
		}
		
		while(a != null && b != null && a.data==b.data){
			a= a.next;
			b= b.next;
		}
		
		if(a!=null && b!= null){
			return (a.data >= b.data ? 1 : -1);
		}
		
		if(a != null && b == null ){
			return 1;
		}
		
		if(a == null && b != null ){
			return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		LCompare_Two_String_In_Linked_Lists list = new LCompare_Two_String_In_Linked_Lists();
		
		list.a = new Node ('a');
		list.a.next = new Node('b');
		list.a.next.next = new Node('c');
		list.a.next.next.next = new Node('d');
		
		list.b = new Node('a');
		list.b.next = new Node('c');
		list.b.next.next = new Node('e');
		
		System.out.println("List a before Merging");
		list.printList(a);
		System.out.println();
		System.out.println("List b before Merging");
		list.printList(b);
		
		int value;
		value = list.compare(a, b);
		System.out.println();
		System.out.println("Output After Comparison");
		System.out.println(value);

	}

}
