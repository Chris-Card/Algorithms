package com.cybergrants.ts.main;

import com.cybergrants.ts.algorithms.graph.*;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    
    public static void main(String args[]){
        
        //Breath First Search
        BFSGraph bfsG = new BFSGraph(4);
        bfsG.addEdge(0, 1);
        bfsG.addEdge(0, 2);
        bfsG.addEdge(1, 2);
        bfsG.addEdge(2, 0);
        bfsG.addEdge(2, 3);
        bfsG.addEdge(3, 3);
        System.out.println("BFS Graph Algo:");
        bfsG.BFS(2);
        
        //Depth First Search
        DFSGraph dfsGraph = new DFSGraph(4);
        dfsGraph.addEdge(0, 1);
        dfsGraph.addEdge(0, 2);
        dfsGraph.addEdge(1, 2);
        dfsGraph.addEdge(2, 0);
        dfsGraph.addEdge(2, 3);
        dfsGraph.addEdge(3, 3);
        System.out.println("DFS Graph Algo");
        dfsGraph.DFS(2);
        
        //Dijkstra Shortest Path
        DIJKSTRAGraph dijkstraGraph = new DIJKSTRAGraph();
        
        // Graph veritices.  0 indicates vertex x is not connected to vertex y 
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, //vertex 0 connected to vertex 1 and 7
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, //vertex 1 connected to vertex 0, 2, 7
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, //vertext 2 connected to vertext 1, 3, 5, 8
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        
        System.out.println("Dijkstra Shortest Path Algo");
        dijkstraGraph.dijkstra(graph, 0);
        
        //Bellman-Ford Shortest Path
        BELLFORDGraph bellfordGraph = new BELLFORDGraph(5,8);
        
        // add edge 0-1 (or A-B in above figure) 
        bellfordGraph.edge[0].src = 0;
        bellfordGraph.edge[0].dest = 1;
        bellfordGraph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure) 
        bellfordGraph.edge[1].src = 0;
        bellfordGraph.edge[1].dest = 2;
        bellfordGraph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure) 
        bellfordGraph.edge[2].src = 1;
        bellfordGraph.edge[2].dest = 2;
        bellfordGraph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure) 
        bellfordGraph.edge[3].src = 1;
        bellfordGraph.edge[3].dest = 3;
        bellfordGraph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure) 
        bellfordGraph.edge[4].src = 1;
        bellfordGraph.edge[4].dest = 4;
        bellfordGraph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure) 
        bellfordGraph.edge[5].src = 3;
        bellfordGraph.edge[5].dest = 2;
        bellfordGraph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure) 
        bellfordGraph.edge[6].src = 3;
        bellfordGraph.edge[6].dest = 1;
        bellfordGraph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure) 
        bellfordGraph.edge[7].src = 4;
        bellfordGraph.edge[7].dest = 3;
        bellfordGraph.edge[7].weight = -3;
        
        System.out.println("Bellman-Ford Shortest Path Algo");
        bellfordGraph.bellmanford(bellfordGraph, 0);
        
        //Prim's MST
        PRIMMst primGraph = new PRIMMst();
        int graphForPrim[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        System.out.println("Prims MST Algo");
        primGraph.primmst(graphForPrim);
        
        
        //Undirected Graph Cyclic Identification
        UNDIRCycle g1 = new UNDIRCycle(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        UNDIRCycle g2 = new UNDIRCycle(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
        
    }
}
