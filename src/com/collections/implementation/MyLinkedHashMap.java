package com.collections.implementation;

public class MyLinkedHashMap<K,V> {
	private int capacity = 4;
	private Entry<K, V> last,header;
	private Entry<K, V>[] table;
	
	static class Entry<K,V>{
		K key;
		V value;
		Entry<K, V> next,after,before;
		
		public Entry(K key,V value,Entry<K, V> next) {
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	public void put(K key,V value){
		if(key==null) return;
		int hash = hash(key);
		Entry<K,V> newEntry = new Entry<K,V>(key, value, null);
		maintainOrderOfInsertion(newEntry);
		if(table[hash]==null){
			table[hash]=newEntry;
		}else{
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while(current!=null){
				if(current.key.equals(key)){
					if(previous==null){
						newEntry.next=current.next;
						table[hash]=newEntry;
						return;
					}else{
						newEntry.next=current.next;
						previous.next=newEntry;
						return;
					}
				}
				previous=current;
				current=current.next;
			}
			previous.next=newEntry;
		}
		
	}
	
	public V get(K key) {
		if(key==null) return null;
		int hash = hash(key);
		if(table[hash]==null){
			return null;
		}else{
			Entry<K, V> current = table[hash];
			while(current!=null){
				if(current.key.equals(key)) return current.value;
				current=current.next;
			}
			return null;
		}
	}
	
	public boolean remove(K key) {
		if(key==null) return false;
		int hash = hash(key);
		if(table[hash]==null){
			return false;
		}else{
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while(current!=null){
				if(current.key.equals(key)){
					maintainOrderOfDeletion(current);
					if (previous==null) {
						table[hash]=table[hash].next;
						return true;
					}else{
						previous.next=current.next;
						return true;
					}
				}
				previous=current;
				current=current.next;
			}
			return false;
		}
	}
	
	private int hash(K key){
		return Math.abs(key.hashCode())%capacity;
	}
	
	private void maintainOrderOfInsertion(Entry<K, V> newEntry) {
		if(header==null){
			header=newEntry;
			last = newEntry;
			return;
		}
		
		if(header.key.equals(newEntry.key)){
			deleteFirst();
			insertFirst(newEntry);
			return;
		}
		
		if(last.key.equals(newEntry.key)){
			deleteLast();
			insertLast(newEntry);
			return;
		}
		
		Entry<K, V> beforeDeleteSpecificKey = deleteSpecificEntry(newEntry);
		if(beforeDeleteSpecificKey==null){
			insertLast(newEntry);
		}else{
			insertAtSpecificKey(beforeDeleteSpecificKey, newEntry);
		}
	}
	
	private void deleteFirst(){
		if(header==last){
			header=last=null;
			return;
		}
		header=header.after;
		header.before=null;
	}
	
	private void insertFirst(Entry<K, V> newEntry){
		if(header==null){
			header=newEntry;
			last=newEntry;
			return;
		}
		newEntry.after=header;
		header.before=newEntry;
		header=newEntry;
	}
	
	private void deleteLast(){
		if(header==last){
			header=last=null;
			return;
		}
		last=last.before;
		last.after=null;
	}
	
	private void insertLast(Entry<K, V> newEntry){
		if(header==null){
			header=newEntry;
			last=newEntry;
			return;
		}
		last.after=newEntry;
		newEntry.before=last;
		last = newEntry;
	}
	
	private Entry<K, V> deleteSpecificEntry(Entry<K, V> newEntry) {
		Entry<K, V> current = header;
		while(!current.key.equals(newEntry.key)){
			if(current.after==null) return null;
			current=current.after;
		}
		Entry<K, V> beforeDeleteSpecificKey = current.before;
		current.before.after=current.after;
		current.after.before=current.before;
		return beforeDeleteSpecificKey;
	}
	
	private void insertAtSpecificKey(Entry<K, V> beforeDeleteSpecificKey,Entry<K, V> newEntry) {
		Entry<K, V> current = header;
		while(!current.equals(beforeDeleteSpecificKey)){
			current=current.after;
		}
		newEntry.after=beforeDeleteSpecificKey.after;
		beforeDeleteSpecificKey.after.before=newEntry;
		newEntry.before=beforeDeleteSpecificKey;
		beforeDeleteSpecificKey.before.after=newEntry;
	}
	
	private void maintainOrderOfDeletion(Entry<K, V> newEntry) {
		if(header.key.equals(newEntry.key)){
			deleteFirst();
			return;
		}
		if(last.key.equals(newEntry.key)){
			deleteLast();
			return;
		}
		deleteSpecificEntry(newEntry);
	}
}