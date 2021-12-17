package com.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class AGraphBFS_DFS {
    private int v;
    private LinkedList<Integer> llist[];

    public AGraphBFS_DFS(int v){
        this.v = v;
        llist = new LinkedList[v];
        for(int i=0;i<v;i++)
            llist[i] = new LinkedList<>();
    }

    public void add(int v,int w){
        llist[v].add(w);
    }

    public void BFS(int s){
        Queue<Integer> queue = new LinkedBlockingDeque<>();
        boolean visited[] = new boolean[v];
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            int out = queue.poll();
            System.out.print(out+"-->");
            Iterator<Integer> list = llist[out].listIterator();
            while (list.hasNext()){
                int k = list.next();
                if(!visited[k]){
                    visited[k]=true;
                    queue.add(k);
                }
            }
        }
        System.out.println("----------------");
    }

    public void DFS(int s){
        boolean visited[] = new boolean[v];
        DFSUtil(s,visited);
        System.out.println("--------------");
    }

    public void DFSUtil(int s, boolean[] visited){
        System.out.print(s+"-->");
        visited[s] = true;
        Iterator<Integer> list = llist[s].listIterator();
        while (list.hasNext()){
            int k = list.next();
            if(!visited[k])
                DFSUtil(k,visited);
        }
    }

    public void DFSStack(int s){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];
        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()){
            int out = stack.pop();
            System.out.print(out+"-->");
            Iterator<Integer> list = llist[out].listIterator();
            while (list.hasNext()){
                int k = list.next();
                if(!visited[k]){
                    visited[k]=true;
                    stack.push(k);
                }
            }
        }
        System.out.println("----------------");
    }

    public static void main(String args[]){
        AGraphBFS_DFS graph = new AGraphBFS_DFS(5);
        graph.add(0,1);
        graph.add(0,2);
        graph.add(1,2);
        graph.add(2,0);
        graph.add(2,3);
        graph.add(3,4);
        graph.BFS(2);
        graph.DFS(2);
        graph.DFSStack(2);
    }
}
