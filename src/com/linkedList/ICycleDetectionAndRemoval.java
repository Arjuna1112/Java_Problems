package com.linkedList;

public class ICycleDetectionAndRemoval {

	Node head;
	
	public static void main(String[] args) {

		ICycleDetectionAndRemoval loopList = new ICycleDetectionAndRemoval();
		
		loopList.head = new Node(10);
		loopList.head.next = new Node(4);
		loopList.head.next.next = new Node(30);
		loopList.head.next.next.next = new Node(20);
		loopList.head.next.next.next.next = new Node(11);
		
		loopList.head.next.next.next.next.next = loopList.head;
		
		loopList.cycleDetectionAndRemoval();
		printList(loopList.head);
	}
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	private boolean cycleDetectionAndRemoval(){
		
		Node slow = head, fast = head;
		boolean loopCheck = false;
		while(fast.next!=null&&fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				System.out.println("Got.....");
				/*loop detection can be at any point in the loop, need not tobe at the end or starting of loop
				so to remove the loop we have to follow below approach*/
				loopCheck = true;
				break;
			}
		}
		if(loopCheck) {
			int noNodeInLoop = getCount(slow);
			Node ptr1 = head, ptr2 = head;
			// And the other pointer to k nodes after head
			for(int i = 0;i<noNodeInLoop;i++){
				ptr2 = ptr2.next;
			}
			/*  Move both pointers at the same pace,
         		they will meet at loop starting node */
			while (ptr1!=ptr2){
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			// Get pointer to the last node
			while (ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

        	/* Set the next node of the loop ending node
         	to fix the loop */
			ptr2.next = null;

		}
		return loopCheck;
	}

	private static int getCount(Node node){
		int count = 1;
		Node l1 = node, l2 = node;
		while (l1.next!=l2){
			count++;
			l1 = l1.next;
		}
		return count;
	}

	private static void printList(Node node){
		while(node != null){
			System.out.print(node.data+",");
			node = node.next;
		}
		System.out.println();
	}

}
