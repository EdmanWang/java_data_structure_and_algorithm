package com.edmanwang.graph;

import com.edmanwang.model.Vertex;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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

    // 深度优先搜索算法实现，按照最大深度去找元素
    public void dfs() {
        // 首先需要一个栈的数据结构去存储数据，这个数据结构是用来可以倒退遍历的数据
        Stack<Vertex> stack = new Stack<>();
        // 需要一个索引去记录遍历的位置
        int index = 0;
        stack.push(vertices[index]);
        // 设置当前这个元素标识为已经访问
        vertices[index].setVisited(true);
        // 既然是已经访问就是说名，这个元素可以打印出来
        System.out.println(vertices[index].getValue());
        out:
        while (!stack.isEmpty()) {
            for (int i = index + 1; i < vertices.length; i++) {
                if (edgeRelation[index][i] == 1 && !vertices[i].isVisited()) {
                    /**
                     * 表示这两个定点是联通的，并且后一个订单没有访问
                     * 则：将定点加入到栈中并设置其为已经访问，并将其打印
                     * 注意：这个时候，需要将遍历的位置向后挪一个，即使刚新添加的位置，再从新添加的位置向后遍历，找到即联通又没有访问的点
                     */
                    stack.push(vertices[i]);
                    vertices[i].setVisited(true);
                    System.out.println(vertices[i].getValue());

                    index++;
                    continue out;
                }
            }

            // 如果没找到的话，就需要弹出栈顶元素，继续从该点的上一个点赵剩下的联通，但是没有访问的点
            stack.pop();
            if (!stack.isEmpty()) {
                Vertex vertex = stack.peek();
                // 将索引位置重置
                index = getIndex(vertex);
            }
        }
    }

    /**
     * 广度优先遍历
     * 1：实现的思路---> 有点像树结构的层次遍历，即表示先要遍历完该节点的下一层全部的节点
     */
    public void wfs() {
        // 首先是需要一个队列的数据结构来存放
        Queue<Vertex> queue = new LinkedBlockingQueue<>();
        Vertex vertex = vertices[0];
        vertex.setVisited(true);
        queue.add(vertex);
        System.out.println(vertex.getValue());
        // 取一个默认的定点开始遍历，默认取存放数据的第一个数据，
        while (!queue.isEmpty()) {
            // 出队列，将第一个数据从队列中出队
            Vertex remove = queue.poll();
            // 拿到索引，遍历该索引联通，并且没有访问的节点
            index = getIndex(remove);
            for (int i = index + 1; i < vertices.length; i++) {
                if (edgeRelation[index][i] == 1 && !vertices[i].isVisited()) {
                    Vertex v = vertices[i];
                    v.setVisited(true);
                    queue.add(v);
                    System.out.println(v.getValue());
                }
            }
        }
        // 将第一个默认的数据加入到队列中，并标识该定点事访问过的
    }

    @Override
    public String toString() {
        return "Graph{" + "edgeRelation=" + Arrays.toString(edgeRelation) + '}';
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
