package com.test;

/*
*                                       1
*                               2       3       4
*                           5      6         7     8
*                                9
*
* */


/*
* class Node {
    public Node(int data, Node[] childNodes) {
    }

    public int height() {
    }
}

public class TreeHeight {
    public static void main(String[] args) {
        Node n3 = new Node(3, null);
        Node n5 = new Node(5, null);
        Node n9 = new Node(9, null);
        Node n7 = new Node(7, null);
        Node n8 = new Node(8, null);
        Node n4 = new Node(4, new Node[] {n7, n8});
        Node n6 = new Node(6, new Node[] {n9});
        Node n2 = new Node(2, new Node[] {n5, n6});
        Node n1 = new Node(1, new Node[] {n2, n3, n4});

        System.out.println(n1.height());
        System.out.println(n2.height());
        System.out.println(n3.height());
    }
}
* */



public class Test {
    public static void main(String[] args) {
        Node n3 = new Node(3, null);
        Node n5 = new Node(5, null);
        Node n9 = new Node(9, null);
        Node n7 = new Node(7, null);
        Node n8 = new Node(8, null);
        Node n4 = new Node(4, new Node[] {n7, n8});
        Node n6 = new Node(6, new Node[] {n9});
        Node n2 = new Node(2, new Node[] {n5, n6});
        Node n1 = new Node(1, new Node[] {n2, n3, n4});

        System.out.println(n1.height());
        System.out.println(n2.height());
        System.out.println(n3.height());
    }
}

class Node {
    int data;
    Node[] childNodes;

    public Node(int data, Node[] childNodes) {
        this.data = data;
        this.childNodes = childNodes;
    }

    public int height() {
        return findHeight(this.childNodes);
    }

    private int findHeight(Node[] currArr){
        int max=0;
        if(currArr==null) return 0;
        for(Node curr:currArr){
            int height = findHeight(curr.childNodes)+1;
            if(height>max) max = height;
        }
        return max;
    }
}
