package com.graph;

import com.queue.AMyQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CAdjacenncy_Linked_List_Graph {
	Vertex[] adjList;
	
	public CAdjacenncy_Linked_List_Graph(String f) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(f));
		boolean undirected = false;
		if(sc.next().equals("undirected"))undirected=true;
		adjList = new Vertex[sc.nextInt()];
		for(int i=0;i<adjList.length;i++){
			adjList[i] = new Vertex(sc.next(), null);
		}
		while(sc.hasNext()){
			int v1 = vertexIndex(sc.next());
			int v2 = vertexIndex(sc.next());
			
			adjList[v1].nbr = new Neighbour(v2, adjList[v1].nbr);
			if(undirected)adjList[v2].nbr = new Neighbour(v1, adjList[v2].nbr);
		}
		sc.close();
	}
	
	private int vertexIndex(String name){
		for(int i=0;i<adjList.length;i++){
			if(adjList[i].name.equals(name))return i;
		}
		return -1;
	}
	
	private void print(){
		for(int i=0;i<adjList.length;i++){
			System.out.print(adjList[i].name);
			for(Neighbour nbr = adjList[i].nbr;nbr!=null;nbr=nbr.next){
				System.out.print("-->"+adjList[nbr.index].name);
			}
			System.out.println();
		}
	}
	
	public void depthFirstTraversal(){
		boolean[] check = new boolean[adjList.length];
		for(int i=0;i<adjList.length;i++){
			if(!check[i]){
				System.out.print(adjList[i].name);
				depthFirstTraversal(i, check);
				System.out.println();
			}
		}
	}
	
	private void depthFirstTraversal(int v,boolean[] check){
		check[v]=true;
		for(Neighbour nbr = adjList[v].nbr;nbr!=null;nbr=nbr.next){
			if(!check[nbr.index]){
				System.out.print("-->"+adjList[nbr.index].name);
				depthFirstTraversal(nbr.index, check);
			}
		}
	}
	
	public void breadthFirstTraversal(){
		AMyQueue queue = new AMyQueue(100);
		boolean[] checks = new boolean[adjList.length];
		for(int i=0;i<adjList.length;i++){
			if(!checks[i]){
				System.out.print(adjList[i].name);
				breadthFirstTraversal(i, checks, queue);
				System.out.println();
			}
		}
		
	}
	
	public void printPath(String source, String destination){
		boolean[] checks = new boolean[adjList.length];
		String[] path = new String[adjList.length];
		int pathIndex = 0;
		toFindPath(source, destination, path, checks, pathIndex);
	}
	
	private void toFindPath(String source, String destination,
			String[] path,boolean[] checks,int pathIndex){
		int vertex = vertexIndex(source);
		checks[vertex]=true;
		path[pathIndex]=source;
		pathIndex++;
		if(source.equals(destination)){
			for(int i=0;i<pathIndex;i++){
				System.out.print(path[i]+"-->");
			}
			System.out.println();
		}else{
			for (Neighbour nbr=adjList[vertex].nbr;nbr!=null;nbr=nbr.next) {
				if(!checks[nbr.index])
					toFindPath(adjList[nbr.index].name, destination, path, checks, pathIndex);
			}
		}
		pathIndex--;
		checks[vertex]=false;
	}
	
	private void breadthFirstTraversal(int v, boolean[] checks, AMyQueue queue){
		checks[v]=true;
		queue.push(v);
		while(!queue.isEmpty()){
			int i = (int)queue.pop();
			for(Neighbour nbr = adjList[i].nbr;nbr!=null;nbr=nbr.next){
				if(!checks[nbr.index]){
					checks[nbr.index]=true;
					System.out.print("-->"+adjList[nbr.index].name);
					queue.push(nbr.index);
				}
			}	
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the File Name :");
		System.out.println(sc.next());
		CAdjacenncy_Linked_List_Graph a = new CAdjacenncy_Linked_List_Graph(sc.next());
		a.print();
		System.out.println("\n DFS");
		a.depthFirstTraversal();
		System.out.println("\n BFS");
		a.breadthFirstTraversal();
		System.out.println("\n Path B/W Bangalore & Mumbai");
		a.printPath("Bangalore", "Mumbai");
		System.out.println("\n Path B/W Chennai & Mumbai");
		a.printPath("Chennai", "Mumbai");
	}
	class Neighbour{
		int index;
		Neighbour next;

		public Neighbour(int index,Neighbour next) {
			this.index=index;
			this.next=next;
		}
	}


	class Vertex{
		String name;
		Neighbour nbr;

		public Vertex(String name,Neighbour nbr){
			this.name=name;
			this.nbr=nbr;
		}
	}
}






