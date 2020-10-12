package com.cybergrants.ts.algorithms.graph;

/*
Prims Minimum Spanning Tree
 */
public class PRIMMst {

    // Number of vertices in the graph
    private static final int V = 5;

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
    
    //Get minimum distance vertex from the unprocessed set.
    //Distance set as part of calculations of a previously processed vertex
    public int getMinKey(int key[], boolean mstSet[]){
        
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int v = 0; v < V; v++){
            if(!mstSet[v] && key[v] < min){
                min = key[v];
                min_index = v;
            }
        }
        
        return min_index;
    }
    
    public void primmst(int graph[][]){
        
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        key[0] = 0;
        parent[0] = -1;
        
        for(int i = 0; i < V-1; i++){
            
            int u = getMinKey(key, mstSet);
            
            mstSet[u] = true;
            
            for(int v = 0; v < V; v++){
                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // print the constructed MST
        printMST(parent, graph);
    }
}
