package com.edmanwang.graph;

import com.edmanwang.model.Vertex;

import java.util.Arrays;
import java.util.Stack;

/**
 * 图对象
 */
public class Graph {

    // 用一个一维数组来维护图中的顶点元素
    private Vertex[] vertices;

    // 用一个二维数组来维护图中各个顶点的关系
    private int[][] edgeRelation;

    // 使用一个索引来记录图中顶点放置的位置
    private int index;

    public Graph(int size) {
        this.vertices = new Vertex[size];
        this.edgeRelation = new int[size][size];
        instanceEdgeRelation();
    }

    // 向图中添加元素
    public void addVertex(Vertex vertex) {
        vertices[index] = vertex;
        index++;
    }

    // 实现图中各个顶点的关系
    public void createEdge(Vertex v1, Vertex v2) {
        int index1 = getIndex(v1);
        int index2 = getIndex(v2);

        if (index1 == -1 || index2 == -1) {
            throw new RuntimeException("请检查你输入的顶点数据");
        }

        edgeRelation[index1][index2] = 1;
        edgeRelation[index2][index1] = 1;
    }

    public int[][] getEdgeRelation() {
        return edgeRelation;
    }

    // 深度优先搜索算法实现
    public void dfs() {
        // 首先需要一个栈的数据结构去存储数据
        Stack<Vertex> stack = new Stack<>();
        // 需要一个索引去记录遍历的位置
        int index = 0;
        stack.push(vertices[index]);
        vertices[index].setVisited(true);
        System.out.println(vertices[index].getValue());
        out:
        while (!stack.isEmpty()) {
            for (int i = index + 1; i < vertices.length; i++) {
                if (edgeRelation[index][i] == 1 && !vertices[i].isVisited()) {
                    stack.push(vertices[i]);
                    vertices[i].setVisited(true);
                    System.out.println(vertices[i].getValue());
                }
            }
            index++;
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "edgeRelation=" + Arrays.toString(edgeRelation) +
                '}';
    }

    // 通过遍历顶点数组拿到顶点元素对应的位置
    private int getIndex(Vertex v) {
        int index = -1;
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];
            if (vertex.getValue().equals(v.getValue())) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 实例化二维数组
    private void instanceEdgeRelation() {
        for (int i = 0; i < edgeRelation.length; i++) {
            for (int j = 0; j < edgeRelation[i].length; j++) {
                if (i == j) {
                    edgeRelation[i][j] = 1;
                }
            }
        }
    }
}
