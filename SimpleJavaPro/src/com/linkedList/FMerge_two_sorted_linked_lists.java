package com.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class FMerge_two_sorted_linked_lists {
	
	/*Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).
	Examples:
	Input:  a: 5->10->15->40
	        b: 2->3->20 
	Output: res: 40->20->15->10->5->3->2
	Input:  a: NULL
	        b: 2->3->20 
	Output: res: 20->3->2*/
	
	Node next;
	static Node a,b;
	
	static class Node {
		
		Node next;
		int data;
		
		Node (int data){
			this.data = data;
		}
	}
	
	void  printList(Node node){
		while(node != null){
			System.out.print(node.data+",");
			node = node.next;
		}
		System.out.println();
	}
	
	Node mergeList(Node a, Node b){
		Node result = null;
		
		if(a==null && b==null){
			return null;
		}
		
		while(a!=null && b!=null){
			if(a.data<=b.data){
				Node temp = a.next;
				a.next = result;
				result = a;
				a = temp;
			}else{
				Node temp = b.next;
				b.next = result;
				result = b;
				b = temp;
			}
		}
		
		while(a!=null){
			Node temp = a.next;
			a.next = result;
			result = a;
			a = temp;
		}
		
		while(b!=null){
			Node temp = b.next;
			b.next = result;
			result = b;
			b = temp;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		FMerge_two_sorted_linked_lists list1 = new FMerge_two_sorted_linked_lists();
		Node result;
		
		list1.a = new Node(5);
		list1.a.next = new Node(10);
		list1.a.next.next = new Node(15);
		list1.a.next.next.next = new Node(40);
		
		list1.printList(a);
		
		list1.b = new Node(2);
		list1.b.next = new Node(3);
		list1.b.next.next = new Node(20);
		
		list1.printList(b);
		
		result = list1.mergeList(a, b);
		list1.printList(result);
		
		
	}
	
	private void mergeAPIList(){
		List<Integer> a = new LinkedList<>();
		List<Integer> b = new LinkedList<>();
		List<Integer> output = new LinkedList<>();
		
		a.add(5);
		a.add(10);
		a.add(15);
		a.add(40);
		
		b.add(2);
		b.add(3);
		b.add(20);
		
		Iterator<Integer> aItr = a.iterator();
		Iterator<Integer> bItr = a.iterator();
		while(aItr.hasNext() && bItr.hasNext()){
			if(aItr.next()<=bItr.next()){
				
			}
		}
	}

	
}
