package com.linkedList;

public class GRemove_Duplicates {
    static Node head;
    static Node left;
    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data=data;
        }
    }

    public static void main(String args[]){
        head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        //Approach 1: Use HashSet, since it's straight not implemented
        //Approach 2: Double while loop to compare one element with rest all
        removeDuplicates(head);
        printList(head);
    }

    private static void removeDuplicates(Node head) {
        Node curr = head, prev = null, next = null;
        if(head==null) return;
        while(curr!=null){
            prev = curr;
            next =curr.next;
            while (next!=null){
                if(next.data==curr.data) prev.next = next.next;
                else prev = next;
                next = next.next;
            }
            curr = curr.next;
        }
    }

    private static void printList(Node node){
        while(node != null){
            System.out.print(node.data+",");
            node = node.next;
        }
        System.out.println();
    }
}
