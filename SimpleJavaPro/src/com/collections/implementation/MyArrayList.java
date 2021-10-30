package com.collections.implementation;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList{
	
	private Object[] myArray;
	private int size;
	private int modCount=0;
	
	public MyArrayList() {
		myArray= new Object[10];
	}
	
	public void add(Object Obj)
	{
		if(size==myArray.length)
		{
			increaseArray(myArray);
		}
		myArray[size]=Obj;
		size++;
		modCount++;
	}
	
	public Object get(int index)
	{
		checkSize(index);
		return myArray[index];
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void remove(int index)
	{
		checkSize(index);
		for(int i = index; i<size; i++)
		{
			/*Object temp = myArray[i-1];
			myArray[i-1]=myArray[i];
			myArray[i]=temp;*/
			myArray[i]=myArray[i+1];
		}
		size--;
		modCount++;
		myArray[size]=null;
	}
	
	public boolean contains(Object Obj)
	{
		for(int i = 0; i<size ;i++)
		{
			if(Obj.equals(myArray[i])) return true;
		}
		return false;
	}
	
	public <E> Iterator<E> iterator()
	{
		return new Itr<E>();
	}
	
	private class Itr<E> implements Iterator<E>
	{
		int next;
		int previous=-1;
		int expectedCount=modCount;
		@Override
		public boolean hasNext() {
			return next!=size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			checkForModification(expectedCount);
			int i=next;
			if(i >= size) throw new NoSuchElementException();
			Object[] listArray=MyArrayList.this.myArray;
			next=i+1;
			previous=i;
			return (E) listArray[previous];
		}
		
	}
	
	private void increaseArray(Object[] myArray)
	{
		myArray=Arrays.copyOf(myArray, myArray.length+10);
	}
	
	private void checkSize(int index)
	{
		if(index>size) throw new IndexOutOfBoundsException();
	}
	
	private void checkForModification(int expectedCount)
	{
		if(modCount!=expectedCount) throw new ConcurrentModificationException();
	}


}
