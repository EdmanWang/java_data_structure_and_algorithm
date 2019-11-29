package com.edmanwang.model;

/**
 * 图的组成部分，顶点
 */
public class Vertex {

    private String value;

    private boolean visited;

    public Vertex(String value) {
        this.value = value;
        this.visited =false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return  value ;
    }
}
