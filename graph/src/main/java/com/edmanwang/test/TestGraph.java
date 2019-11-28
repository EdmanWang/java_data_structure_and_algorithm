package com.edmanwang.test;

import com.edmanwang.graph.Graph;
import com.edmanwang.model.Vertex;

import java.util.Arrays;

public class TestGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.createEdge(v1, v2);
        graph.createEdge(v1, v3);
        graph.createEdge(v2, v3);
        graph.createEdge(v2, v4);
        graph.createEdge(v2, v5);

        for (int[] arr : graph.getEdgeRelation()){
            System.out.println(Arrays.toString(arr));
        }

        graph.dfs();
    }
}
