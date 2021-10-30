package com.tree.implementation;

//In an AVL tree, the heights of the two child subtrees of any node differ by at most one; therefore, it is also said to be height-balanced.

public class MyAVL {
	
	private static Node root;
	
	private Node insert(Node root, int data){
		int balance;
		if(root==null){
			root = new Node(data);
		}
		else if(data<=root.data){
			root.left = insert(root.left,data);
		}
		else{
			root.right = insert(root.right,data);
		}
		root.height = max(height(root.left),height(root.right))+1;
		balance = balance(root);
		//left left
		if(balance > 1 && data < root.left.data) 
			return rotateRight(root);
		//right right
		if(balance < -1 && data > root.right.data) 
			return rotateLeft(root);
		//left right
		if(balance > 1 && data > root.left.data)
		{	root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		//right left
		if(balance < -1 && data < root.right.data)
		{	root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		return root;
	}
	
	private int height(Node root){
		if(root==null) return 0;
		return root.height;
	}
	
	private int max(int left, int right){
		if(left>right) return left;
		else return right;
	}
	
	private int balance(Node root){
		if(root==null) return 0;
		return (height(root.left)-height(root.right));
	}
	
	private Node rotateRight(Node y){
		Node x = y.left;
		Node T2 = x.right;
		x.right = y;
		y.left = T2;
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		return x;
	}
	
	private Node rotateLeft(Node x){
		Node y = x.right;
		Node T2 = y.left;
		y.left = x;
		x.right = T2;
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		return y;
	}
	
	public void insert(int data){
		root= insert(root,data);
	}
	
	private class Node
	{
		private Node left;
		private Node right;
		private int data;
		private int height;
		
		public Node(int data)
		{
			this.data=data;
		}
	}


	
}
