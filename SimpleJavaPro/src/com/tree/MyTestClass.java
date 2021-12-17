package com.tree;

public class MyTestClass {

	public static void main(String[] args) {
		//Binary Search Tree
		/*						15

						10				20

					8    12   		18     32

				6   9  11   13   16   19   26   34*/
		ABST_Basic_Problems myBST = new ABST_Basic_Problems();
		myBST.insert(15);
		myBST.insert(10);
		myBST.insert(20);
		myBST.insert(12);
		myBST.insert(32);
		myBST.insert(8);
		myBST.insert(18);
		myBST.insert(6);
		myBST.insert(9);
		myBST.insert(11);
		myBST.insert(13);
		myBST.insert(16);
		myBST.insert(19);
		myBST.insert(26);
		myBST.insert(34);
		myBST.find_kth_Smallest_Highest_Element(3);
		//myBST.swapEveryKLevel(2);
		//myBST.countSubTreeInRange();
		/*myBST.createSumTree();
		myBST.checkSumTree();*/
		//myBST.bottomView();
		//myBST.removeOutsideTheRange(34,8);
		//myBST.find_kth_Smallest_Highest_Element(4);
		/*System.out.println("Success");
		System.out.println(myBST.search(20));
		System.out.println(myBST.findMin());
		System.out.println(myBST.findMax());
		System.out.println(myBST.findHeight());
		System.out.println(myBST.isBST());
		System.out.println(myBST.delete(100));
		myBST.levelOrderTraversal();*/
		//System.out.println("PreOrderTraversal *****");
		//myBST.preOrderTraversal();//15,10,8,6,9,12,11,13,20,18,16,19,32,26,34
		/*System.out.println("\n"+"InOrderTraversal *****");
		myBST.inOrderTraversal();
		System.out.println("\n"+"PostOrderTraversal *****");
		myBST.postOrderTraversal();
		myBST.mirror();
		myBST.rePopulateTree();
		
		//AVL Tree
		MyAVL myAVL= new MyAVL();
		myAVL.insert(10);
		System.out.println("Success1");
		myAVL.insert(20);
		System.out.println("Success2");
		myAVL.insert(15);
		System.out.println("Success3");
		myAVL.insert(25);
		System.out.println("Success4");
		myAVL.insert(30);
		System.out.println("Success5");
		myAVL.insert(35);
		System.out.println("Success6");
		myAVL.insert(40);
		System.out.println("Success7");
		myAVL.insert(45);
		System.out.println("Success8");*/
		
		
		
	}

}
