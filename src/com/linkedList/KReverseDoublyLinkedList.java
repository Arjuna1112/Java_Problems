package com.linkedList;

import java.util.*;

public class KReverseDoublyLinkedList {

    static Node head;

    public static void main(String[] args){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.prev = node;
        node.next.next = new Node(3);
        node.next.next.prev = node.next;
        node.next.next.next = new Node(4);
        node.next.next.next.prev = node.next.next;
        head = node;
        print();
        reverse();
        print();
    }

    public static String isValid(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c:s.toCharArray()){
            charMap.put(c,charMap.get(c)==null?1:charMap.get(1)+1);
        }
        int count = 0;
        for(char c:charMap.keySet()){
            if(charMap.get(c)>1)count++;
            if(count>1) return "NO";
        }
        return "YES";
    }

    static void print(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr = curr.next;
        }
        System.out.println();
    }

    static void reverse(){
        Node temp = null;
        Node curr = head;
        while(curr!=null){
            temp = curr.prev; // temp points to prev of curr i.e, null
            curr.prev = curr.next; //previous of curr points to next of curr i.e, 1 prev point next of 1 i.e, 2
            curr.next = temp; //next of current points to prev of curr
            curr = curr.prev; // curr shifts pointer to its current previous pointer i.e, 2
        }
        if(temp!=null)head = temp.prev;
    }

    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
        }
    }
}


