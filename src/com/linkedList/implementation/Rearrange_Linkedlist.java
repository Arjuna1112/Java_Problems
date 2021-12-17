package com.linkedList.implementation;

public class Rearrange_Linkedlist {

	/*Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list 
	 * so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
	You are required do this in-place without altering the nodes’ values.
	Examples:
	Input:  1 -> 2 -> 3 -> 4
	Output: 1 -> 4 -> 2 -> 3
	Input:  1 -> 2 -> 3 -> 4 -> 5
	Output: 1 -> 5 -> 2 -> 4 -> 3 */
	
	static Node a;
	
	static class Node{
		int data;
		Node next;
		
		Node (int d){
			data = d;
			next = null;
		}
	}
	
	void printList(Node node){
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	Node reverse(Node a){
		Node curr = a, next, prev=null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		 a = prev;
		 return a;
	}
	
	void rearrange(Node node){
		
		Node slow=node, fast=slow.next;
		
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node node1 = node;
		Node node2 = slow.next;
		slow.next = null;
		//node1 = slow;
		
		node2 = reverse(node2);
		
		node = new Node(0);
		
		Node curr = node;
		
		while(node1!=null || node2!=null){
			
			if(node1!=null){
				curr.next = node1;
				curr = curr.next;
				node1= node1.next;
			}
			
			if(node2!=null){
				curr.next = node2;
				curr = curr.next;
				node2= node2.next;
			}
		}
		
		node = curr.next;
	}
	
	public static void main(String[] args) {
		
		Rearrange_Linkedlist list = new Rearrange_Linkedlist();
		
		list.a = new Node(1);
		list.a.next = new Node(2);
		list.a.next.next = new Node(3);
		list.a.next.next.next = new Node(4);
		list.a.next.next.next.next = new Node(5);
		
		System.out.println("List Before Rearranging ");
		list.printList(a);
		System.out.println();
		list.rearrange(a);
		System.out.println("List After Rearranging ");
		list.printList(a);

	}

}
