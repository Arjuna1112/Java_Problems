package com.collections.implementation;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer,Integer> linkedMap = new LinkedHashMap<>();
	int capacity;

	public static void main(String args[]){
		LRUCache lruCache = new LRUCache(3);
		lruCache.put(1,1);
		lruCache.put(2,2);
		lruCache.put(3,3);
		lruCache.put(4,4);
		lruCache.put(3,3);
		System.out.println(lruCache.linkedMap);
		lruCache.put(5,5);
		System.out.println(lruCache.linkedMap);
		lruCache.get(4);
		System.out.println(lruCache.linkedMap);
		System.out.println(lruCache.get(2));
		lruCache.get(3);
		System.out.println(lruCache.linkedMap);
	}

	public LRUCache(int capacity){
		this.capacity = capacity;
	}

	public void put(int key, int value){
		if(!linkedMap.containsKey(key) && linkedMap.size()==capacity)
			linkedMap.remove(linkedMap.keySet().iterator().next());
		if(linkedMap.containsKey(key))
			linkedMap.remove(key);
		linkedMap.put(key,value);
	}

	public int get(int key){
		if(!linkedMap.containsKey(key))	return -1;
		int val = linkedMap.get(key);
		linkedMap.remove(key);
		linkedMap.put(key,val);
		return val;
	}
	
}
