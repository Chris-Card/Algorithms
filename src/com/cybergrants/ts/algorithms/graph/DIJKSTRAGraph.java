package com.cybergrants.ts.algorithms.graph;

public class DIJKSTRAGraph {
    
    static final int V = 9;

    // A utility function to print the constructed distance array 
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    
    //Helper function - Returns vertex with the least distance from src (calculated as part of a previous vertex iteration)
    //which is not yet been processed itself.
    public int minDistance(int dist[], boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        
        for(int v=0; v < V; v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        
        return min_index;
    }
    
    //Find the shortest path to all vertices from a source vertext
    public void dijkstra(int graph[][], int src){
        
        //Initialize Distance and SPTSet (has it been processed) arrays
        int dist[] = new int[V];
        boolean sptSet[] = new boolean[V];
        
        //Set all distances to infinity and all vertices to NOT processed
        for(int i=0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        
        //Set source distance to 0 (no distance from source to source)
        dist[src] = 0;
        
        //For each vertex...
        for(int count = 0; count < V; count++){
            
            //Get the vertex with the least distance from source.
            //This vertex has not been processed itself but has had distance
            //Calculated by either a) dist[src] = 0 or by the for loop below
            //Source is always first.
            int u = minDistance(dist, sptSet);
            
            //Set vertex to process state
            sptSet[u] = true;
            
            //Loop through unprocessed vertexes and update their distance from source
            //if the distance to source through the current vertex (u) is less than
            //the distance calculated by a previously connected vertex
            for(int v = 0; v < V; v++){
                
                if(
                    !sptSet[v] && //Skip if already processed
                    graph[u][v] != 0 && //Skip if u and v vertices are not connected
                    dist[u] != Integer.MAX_VALUE && //Skip if us distance is infinity
                    dist[u] + graph[u][v] < dist[v] //Skip if distance from source to v through u is greater than distance from source to v through x (another vertex previously calculated)
                ){
                    dist[v] = dist[u] + graph[u][v]; //Update v's distance to source with lower value (through u)
                }
            }
        }

        // print the constructed distance array 
        printSolution(dist);
    }
}
