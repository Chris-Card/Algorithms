package com.cybergrants.ts.algorithms.graph;

/*
Used to from SPT on weighted graphs with negative weights. Has higher time complexity than Dijkstra, however 
Dijkstra can't be used on negative weighed graphs
 */
public class BELLFORDGraph {
    
    public class Edge{
        public int src;
        public int dest;
        public int weight;
        Edge(){
            src = dest = weight = 0;
        }
    }
    
    int V, E;
    public Edge edge[];
    
    public BELLFORDGraph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        
        for(int i = 0; i < e; i++){
            edge[i] = new Edge();
        }
    }

    // A utility function used to print the solution 
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public void bellmanford(BELLFORDGraph graph, int src){
        int V = graph.V;
        int E = graph.E;
        
        int dist[] = new int[V];
        
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[src] = 0;
        
        for(int i = 0; i < V; i++){
            for(int j = 0; j < E; j++){
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                }
            }
        }
        
        for(int j = 0; j < E; j++){
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        
        printArr(dist, V);
    }
}
