package com.collections.implementation;

public class MyStack {
	
	private Object[] object;
	private int top;
	private int stackSize;
	
	public MyStack()
	{
		stackSize=1;
		top=-1;
		object= new Object[stackSize];
	}
	
	public void push(Object data)
	{
		if(top>=stackSize-1) reSize();
		object[++top]=data;
	}
	
	public Object pop()
	{
		if(top<0) return null;
		return object[top--];
	}
	
	public void reSize()
	{
		Object[] temp = object;
		stackSize=stackSize*2;
		object = new Object[stackSize];
		for(int i=0; i<=top;i++)
		{
			object[i]=temp[i];
		}
	}

	public boolean isEmpty() {
		return stackSize==0;
	}
}
