package com.cybergrants.ts.algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
    
    int V;
    LinkedList<Integer> adj[];
    
    public BFSGraph(int v){
        V = v;
        adj = new LinkedList[V];
        
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    public void BFS(int s){
        
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList();
        
        visited[s] = true;
        queue.add(s);
        
        while(queue.size() > 0){
            
            s = queue.poll();
            System.out.println(s+" ");
            
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
