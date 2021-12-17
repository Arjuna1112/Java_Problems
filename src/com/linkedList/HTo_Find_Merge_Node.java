package com.linkedList;

public class HTo_Find_Merge_Node {
    static Node l1;
    static Node l2;
    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data=data;
        }
    }

    public static void main(String args[]){
        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);

        l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        System.out.println(findMergeNode(l1,l2));
    }

    private static int findMergeNode(Node l1, Node l2){
        int l1Size = getCount(l1);
        int l2Size = getCount(l2);
        int diff = l1Size-l2Size;
        if(diff>0)return getMergeNodeData(l1, l2,Math.abs(diff));
        else return getMergeNodeData(l2,l1,Math.abs(diff));
    }

    private static int getCount(Node node){
        int count = 0;
        while (node!=null){
            count++;
            node = node.next;
        }
        return count;
    }

    private static int getMergeNodeData(Node l1, Node l2, int diff){
        for(int i=0;i<diff;i++){
            l1 = l1.next;
        }
        while (l1!=null && l2!=null){
            if(l1.data==l2.data) return l1.data;
            l1 = l1.next;
            l2 = l2.next;
        }
        return -1;
    }

}
