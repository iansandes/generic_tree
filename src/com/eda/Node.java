package com.eda;

import java.util.ArrayList;

public class Node<T> {
    private T value;
    Node<T> parentNode;
    Node<T> left;
    Node<T> right;
    ArrayList<Node<T>> children = new ArrayList<>();

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int getIntValue() {
        int value = (int) this.value;
        return value;
    }

    public void setValor(T value) {
        this.value = value;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public void addChild(Node<T> childNode) {
        children.add(childNode);
        childNode.setParentNode(this);
    }

    public ArrayList getChildren() {
        return children;
    }

    public int getDegree() {
        return children.size();
    }

    public String toString() {
        return value + "";
    }


}