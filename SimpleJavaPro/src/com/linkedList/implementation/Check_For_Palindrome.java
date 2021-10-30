package com.linkedList.implementation;

public class Check_For_Palindrome {
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
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println(checkForPalindromeWithRecursion(head));
        System.out.println(checkForPalindromeWithOutRecursion(head));
    }

    private static boolean checkForPalindromeWithRecursion(Node right){
        if (right == null) return true;
        left = head;
        boolean check = checkForPalindromeWithRecursion(right.next);
        if(check==false) return false;
        boolean check1 = (left.data==right.data);
        left = left.next;
        return check1;
    }

    private static boolean checkForPalindromeWithOutRecursion(Node head){
        Node curr = head, rev = null;

        while(curr!=null){
            Node temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
        }
        curr = head;
        while (rev!=null && curr != null){
            if(rev.data != curr.data) return false;
            rev = rev.next;
            curr = curr.next;
        }

        return true;
    }
}
