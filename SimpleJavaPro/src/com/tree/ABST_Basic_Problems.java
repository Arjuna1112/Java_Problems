package com.tree;


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import com.queue.AMyQueue;
import com.stack.AMyStack;


public class ABST_Basic_Problems {
	
	private static Node root;int sum;

	private Node insert(Node root, int data){
		if(root==null){
			root = new Node(data);
		}
		else if(data<=root.data){
			root.left = insert(root.left,data);
		}
		else{
			root.right = insert(root.right,data);
		}
		return root;
	}

	private boolean search (Node root,int data){
		if(root==null)return false;
		else if(root.data==data)return true;
		else if(data<=root.data) return search(root.left, data);
		else return search(root.right, data);
	}

	private Node delete(Node root, int data){
		if(root == null) return root;
		else if (data<root.data) root.left = delete(root.left, data);
		else if (data>root.data) root.right = delete(root.right, data);
		else{
			if(root.left==null && root.right==null){
				root=null;
			}
			else if(root.left==null){
				Node temp=root;
				root=root.right;
				temp.right = null;
			}
			else if(root.right==null){
				Node temp=root;
				root=root.left;
				temp.left = null;
			}
			else{
				Node temp= findMinToDelete(root.right);
				root.data = temp.data;
				root.right = delete(root.right,temp.data);
			}
		}
		return root;
	}

	private Node findMinToDelete(Node root){
		if(root == null) return root;
		else if(root.left==null) return root;
		return findMinToDelete(root.left);
	}

	private void preOrderTraversal(Node root){
		if(root==null) return;
		System.out.print(root.data+",");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private void inOrderTraversal(Node root){
		if(root==null) return;
		inOrderTraversal(root.left);
		System.out.print(root.data+",");
		inOrderTraversal(root.right);
	}

	private void postOrderTraversal(Node root){
		if(root==null) return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+",");
	}

	private void levelOrderTraversal(Node root){
		if(root==null) return;
		Queue<Node> q = new ArrayBlockingQueue<>(10);
		q.add(root);
		while(!q.isEmpty()){
			Node current = q.poll();
			System.out.print(current.data+",");
			if(current.left!=null) q.add(current.left);
			if(current.right!=null) q.add(current.right);
		}
	}

	private int findHeight(Node root){
		if(root == null) return -1;
		return max(findHeight(root.left),findHeight(root.right))+1;
	}

	private int max(int leftheight, int rightheight){
		return leftheight>=rightheight?leftheight:rightheight;
	}

	private int findMin(Node root){
		if(root == null) return -1;
		else if(root.left==null) return root.data;
		return findMin(root.left);
	}
	
	private int findMax(Node root){
		if(root == null) return -1;
		else if(root.right==null) return root.data;
		return findMax(root.right);
	}
	
	private boolean isBSTUtil(Node root, Node l, Node r){
		if(root==null) return true;
		if(l!=null && root.data<=l.data) return false;
		if(r!=null && root.data>=r.data) return false;
		return isBSTUtil(root.left,l,root) &&
				isBSTUtil(root.right,root,r);
	}
	
	private void mirror(Node root){
		if(root == null) return;
		processNode(root);
		mirror(root.left);
		mirror(root.right);
	}
	
	private void processNode(Node root){
		if(root == null) return;
		Node temp = root.left;
		root.left=root.right;
		root.right=temp;
	}

	int count;
	private int numberOfLeafNodes(Node root){
		if(root ==null) return -1;
		if(root.left==null && root.right==null) return 1;
		return numberOfLeafNodes(root.left)+numberOfLeafNodes(root.right);
		/*if(root ==null) return -1;
		numberOfLeafNodes(root.left);
		numberOfLeafNodes(root.right);
		if(root.left==null && root.right==null) {
			count++;
		}
		return count;*/
	}
	
	private Node sumOfTwoChild(Node root){
		if(root == null)return root;
		if(root.left!=null && root.right!=null){
			root.data = root.left.data+root.right.data;
			sumOfTwoChild(root.left);
			sumOfTwoChild(root.right);
		}
		return root;
	}
	
	private Node lowestCommonAncestor(Node root, int n1, int n2){
		if(root == null) return null;
		if (n1==root.data || n2==root.data) return root;
		Node leftLCA = lowestCommonAncestor(root.left,n1,n2);
		Node rightLCA = lowestCommonAncestor(root.right,n1,n2);
		if(leftLCA!=null&&rightLCA!=null) return root;
		return leftLCA!=null?leftLCA:rightLCA;
	}
	
	private Node sumOfGreaterValueToEveryNode(Node root){
		if(root == null) return root;
		sumOfGreaterValueToEveryNode(root.right);
		sum = sum+root.data;
		root.data = sum;
		sumOfGreaterValueToEveryNode(root.left);
		return root;
	}
	
	private Node removeOutsideTheRange(Node root, int max, int min){
		if(root==null) return root;
		root.left=removeOutsideTheRange(root.left, max, min);
		root.right=removeOutsideTheRange(root.right, max, min);
		if(root.data<min){
			Node temp = root.right;
			root = null;
			return temp;
		}
		if(root.data>max){
			Node temp = root.left;
			root = null;
			return temp;
		}
		return root;
	}
	
	private void printSpiral(Node root){
		if(root==null) return;
		AMyStack s1 = new AMyStack();
		AMyStack s2 = new AMyStack();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node node = (Node) s1.pop();
				System.out.print(node.data+",");
				if(node.left!=null) s2.push(node.left);
				if(node.right!=null) s2.push(node.right);
			}
			while(!s2.isEmpty()){
				Node node = (Node) s2.pop();
				System.out.print(node.data+",");
				if(node.right!=null) s1.push(node.right);
				if(node.left!=null) s1.push(node.left);
			}
		}
	}

	private void topView(Node root,int w,int h,Map<Integer,Pair> treeMap){
		if (root==null) return;
		topView(root.left,w-1,h+1,treeMap);
		if (!treeMap.containsKey(w))treeMap.put(w,new Pair(root.data,h));
		else if(treeMap.get(w).height >h) treeMap.put(w,new Pair(root.data,h));
		topView(root.right,w+1,h+1,treeMap);
	}

	private void bottomView(Node root,int w, int h, Map<Integer,Pair> treeMap){
		if (root==null) return;
		bottomView(root.left,w-1,h+1,treeMap);
		if(!treeMap.containsKey(w)) treeMap.put(w,new Pair(root.data,h));
		else if(treeMap.get(w).height<h) treeMap.put(w,new Pair(root.data,h));
		bottomView(root.right,w+1,h+1,treeMap);
	}

	int i = 0;
	private Node find_kth_SmallestElement(Node root, int kth){
		if(root==null) return null;
		Node left = find_kth_SmallestElement(root.left,kth);
		if(left!=null) return left;
		i++;
		if(kth==i) return root;
		return find_kth_SmallestElement(root.right,kth);
	}

	int j = 0;
	private Node find_kth_HighestElement(Node root, int kth){
		if (root==null) return null;
		Node right = find_kth_HighestElement(root.right,kth);
		if(right!=null) return right;
		j++;
		if(kth == j) return root;
		return find_kth_HighestElement(root.left,kth);
	}

	Map<Integer, Integer> dataMap = new HashMap<>();
	private void rePopulateTree(Node root, int currVal) {
		while (root != null) {
			root.data = dataMap.get(currVal);

			if (root.left != null) {
				rePopulateTree(root.left, currVal-1);
			}

			if (root.right!= null) {
				rePopulateTree(root.right, currVal+1);
			}
		}
	}

	private int createTreeWithSumOfItsChild(Node root){
		if (root==null) return 0;
		if(root.left==null && root.right==null) return root.data;
		root.data = createTreeWithSumOfItsChild(root.left)+createTreeWithSumOfItsChild(root.right);
		int val = root.data;
		return root.data+val;
	}

	private int checkSumTree(Node root){
		int ls, rs;
		if(root==null || (root.left==null && root.right==null)) return 1;
		ls = sumTree(root.left);
		rs = sumTree(root.right);
		if(root.data==ls+rs && checkSumTree(root.left)!=0 && checkSumTree(root.right)!=0) return 1;
		return 0;
	}

	private int sumTree(Node root){
		if(root==null) return 0;
		return sumTree(root.left)+root.data+sumTree(root.right);
	}

	private Node countSubTreeInRange(Node root, int min, int max, List<Node> trees){
		if(root==null) return null;
		root.left=countSubTreeInRange(root.left, min, max, trees);
		root.right=countSubTreeInRange(root.right,min,max,trees);
		if(root.data>=min && root.data<=max) trees.add(root);
		return root;
	}

	private void swapKEveryLevel(Node root,int k,int level){
		if(root==null) return;
		if((level+1)%k==0){
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		swapKEveryLevel(root.left,k,level+1);
		swapKEveryLevel(root.right,k,level+1);
	}

	public void insert(int data){ root= insert(root,data); }

	public boolean search(int data){ return search(root,data); }

	public void delete(int data){ delete(root,data);	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	public void inOrderTraversal() { inOrderTraversal(root); }

	public void postOrderTraversal() { postOrderTraversal(root); }

	public void levelOrderTraversal(){ levelOrderTraversal(root); }

	public int findHeight(){ return findHeight(root); }

	public int findMin(){ return findMin(root);	}
	
	public int findMax(){ return findMax(root); }
	
	public boolean isBST() { return isBSTUtil(root,null,null);	}

	public void mirror(){
		System.out.println("\n"+"Before Mirror *****");
		preOrderTraversal();
		mirror(root);
		System.out.println("\n"+"After Mirror *****");
		preOrderTraversal();
	}

	public int numberOfLeafNodes(){	return numberOfLeafNodes(root);	}

	public void sumOfTwoChild() {
		sumOfTwoChild(root);
		inOrderTraversal();
	}
	
	public void lowestCommonAncestor(int n1, int n2) {
		Node node= lowestCommonAncestor(root,n1,n2);
		System.out.println("Common Ancestor"+ node.data);
	}
	
	public void sumOfGreaterValueToEveryNode() {
		sumOfGreaterValueToEveryNode(root);
	}
	
	public void removeOutsideTheRange(int max, int min) {
		removeOutsideTheRange(root,max,min);
		inOrderTraversal();
	}
	
	public void printSpiral(){
		System.out.println();
		printSpiral(root);
	}

	public void topView(){
		TreeMap<Integer,Pair> treeMap = new TreeMap<>();
		topView(root,0,0,treeMap);
		for (Map.Entry<Integer, Pair> i : treeMap.entrySet())
			System.out.print(i.getValue().nodeData+" ");
	}

	public void bottomView(){
		Map<Integer,Pair> treeMap = new TreeMap<>();
		bottomView(root,0,0,treeMap);
		for (Map.Entry<Integer, Pair> i : treeMap.entrySet())
			System.out.print(i.getValue().nodeData+" ");
		System.out.println("--------------");
	}
	
	public void rePopulateTree(){
		rePopulateTree(root, 0);
	}

	public void find_kth_Smallest_Highest_Element(int data){
		Node small = find_kth_SmallestElement(root, data);
		System.out.println(data+"th Small Element of BST "+small.data);
		Node big = find_kth_HighestElement(root,data);
		System.out.println(data+"th Big Element of BST "+big.data);
	}

	public void createTreeWithSumOfItsChild(){
		createTreeWithSumOfItsChild(root);
		inOrderTraversal();
	}

	public void checkSumTree(){
		System.out.println(checkSumTree(root));
	}

	public void countSubTreeInRange(){
		List<Node> trees = new ArrayList<>();
		countSubTreeInRange(root,10,20,trees);
		System.out.println("Count of Trees In Given Range "+trees.size());
		trees.forEach(root->System.out.println(root.data));
	}

	public void swapEveryKLevel(int k){
		inOrderTraversal();
		swapKEveryLevel(root,k,1);
		inOrderTraversal();
	}

	private class Node
	{
		private Node left;
		private Node right;
		private int data;
		
		public Node(int data)
		{
			this.data=data;
		}
	}

	private class Pair{
		int nodeData;
		int height;
		public Pair(int key, int num){
			this.nodeData=key;
			this.height=num;
		}
	}
}
