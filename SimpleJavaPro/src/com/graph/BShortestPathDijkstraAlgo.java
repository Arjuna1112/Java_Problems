package com.graph;

public class BShortestPathDijkstraAlgo {

    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        BShortestPathDijkstraAlgo t = new BShortestPathDijkstraAlgo();
        t.dijkstra(graph, 0, 9);
    }

    private void dijkstra(int[][] graph, int src, int noOfVtx){
        Boolean[] visited = new Boolean[noOfVtx];
        int[] distArr = new int[noOfVtx];
        for(int i=0;i<noOfVtx;i++){
            visited[i] = false;
            distArr[i] = Integer.MAX_VALUE;
        }
        distArr[src] = 0;
        //To loop over all vertices to find shorter path for all
        for(int count = 0;count<noOfVtx-1;count++){
            //To find minimum weight of vertex in given graph
            int vtxOfMinVal = findMinValInAllVtx(distArr,visited);
            visited[vtxOfMinVal] = true;
            //To find shorter path from vtxOfMinVal to all connecting path
            for(int v=0;v<noOfVtx;v++){
                if(visited[v]==false && graph[vtxOfMinVal][v] !=0 &&
                (distArr[vtxOfMinVal]+graph[vtxOfMinVal][v])<distArr[v]){
                    distArr[v] = distArr[vtxOfMinVal]+graph[vtxOfMinVal][v];
                }
            }
        }

        for(int i =0;i<noOfVtx;i++)
            System.out.println(i+" --> "+distArr[i]);
    }

    private int findMinValInAllVtx(int[] distArr, Boolean[] visited){
        int minValVtx = 0, min_val = Integer.MAX_VALUE;
        for(int i=0;i<distArr.length;i++){
            if(distArr[i]!=Integer.MAX_VALUE
                    && visited[i]==false
                        && distArr[i]<min_val) {
                minValVtx = i;
                min_val = distArr[i];
            }
        }
        return minValVtx;
    }

}
