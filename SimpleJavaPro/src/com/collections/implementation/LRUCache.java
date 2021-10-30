package com.collections.implementation;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	int capacity;
	Node head,end;
	Map<Integer,Node> map = new HashMap<Integer,Node>();
	
	static class Node{
		Node next,prev;
		Object value;int key;
		public Node(int key,Object value){
			this.key=key;
			this.value=value;
		}
	}
	
	public LRUCache(int capacity){
		this.capacity=capacity;
	}
	
	private void remove(Node n){
		if(n.prev!=null){
			n.prev.next=n.next;
		}else{
			head=n.next;
		}
		if(n.next!=null){
			n.next.prev=n.prev;
		}else{
			end = n.prev;
		}
	}
	
	private void setHead(Node n){
		n.next=head;
		n.prev=null;
		if(head!=null){
			head.prev=n;
		}
		head=n;
		if(end==null){
			end = head;
		}
	}
	
	public Object get(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}
	
	public void set(int key,int value){
		if(map.containsKey(key)){
			Node n = map.get(key);
			n.value=value;
			remove(n);
			setHead(n);
		}else{
			Node newNode = new Node(key,value);
			if(map.size()>=capacity){
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			}else{
				setHead(newNode);
			}
			map.put(key, newNode);
		}
	}
	
	
}
