package com.cybergrants.ts.algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
    
    int V;
    LinkedList<Integer> adj[];
    
    public DFSGraph(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    public void DFSUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.println(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }
    
    public void DFS(int s){
        boolean visited[] = new boolean[V];
        DFSUtil(s, visited);
    }
}
