package com.linkedList.implementation;

public class Swap_Pair_Of_Nodes {

    static Node head;

    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data=data;
        }
    }

    public static void main(String args[]){
        Swap_Pair_Of_Nodes swap = new Swap_Pair_Of_Nodes();
        swap.head = new Node(1);
        swap.head.next = new Node(2);
        swap.head.next.next = new Node(3);
        swap.head.next.next.next = new Node(4);
        swap.head.next.next.next.next = new Node(5);
        System.out.println(swap.printList());
        swap_Pair_Of_Nodes(1,4);
        System.out.println(swap.printList());
    }
    //1, 2, 3, 4, 5, 6 (2, 5)
    //1, 5, 3, 4, 2, 6
    private static void swap_Pair_Of_Nodes(int x, int y){
        Node cX=head,cY=head,pX=null,pY=null;

        if(head == null || x==y) return;

        while (cX!=null && cX.data!=x){
            pX=cX;
            cX=cX.next;
        }

        while (cY!=null && cY.data!=y){
            pY=cY;
            cY=cY.next;
        }

        Node temp = cY.next;
        cY.next = cX.next;
        cX.next = temp;

        if(pX!=null && pY!=null){
            pX.next = cY;
            pY.next = cX;
        }

        if(pX==null){
            head = cY;
            pY.next = cX;
        }

        if(pY==null){
            head = cX;
            pX.next = cY;
        }
    }

    public String printList(){
        String output = "";
        Node curr = head;
        while(curr!=null){
            output = output+curr.data + "--->";
            curr = curr.next;
        }
        output=output+"TAIL";
        return output;
    }
}
