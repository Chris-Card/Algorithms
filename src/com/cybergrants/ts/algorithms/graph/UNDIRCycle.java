package com.cybergrants.ts.algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
Undirected Graph Cycle Detection. Start with a DFS 
 */
public class UNDIRCycle {
    
    private int V;
    private LinkedList<Integer> adj[];
    
    public UNDIRCycle(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    
    private Boolean isCyclicUtil(int v, boolean visited[], int parent){
        visited[v] = true;
        Integer i;
        
        //Iterate through connected nodes and see if any nodes are
        //the parent node.
        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()){
            i = it.next();
            
            if(!visited[i]){
                if(isCyclicUtil(i, visited, v)){
                    return true;
                };
            } else if (i != parent){
                return true;
            }
        }
        
        return false;
    }
    
    public Boolean isCyclic(){
        boolean visited[] = new boolean[V];
        for(int i = 0; i<V; i++){
            visited[i] = false;
        }
        
        for(int u = 0; u < V; u++){
            if(!visited[u]){
                if(isCyclicUtil(u, visited, -1)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
