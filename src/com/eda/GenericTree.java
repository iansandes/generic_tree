package com.eda;

import java.util.*;

public class GenericTree<T> {
    private Node<T> root;

    public Node<T> root() {
        return root;
    }

    public GenericTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot(){
        return this.root;
    }

    public ArrayList<Node<T>> returnAllNodes(Node<T> node){
        ArrayList<Node<T>> listOfNodes = new ArrayList<Node<T>>();
        addAllNodes(node, listOfNodes);
        return listOfNodes;
    }

    private void addAllNodes(Node<T> node, ArrayList<Node<T>> listOfNodes) {
        if (node != null) {
            if (isRoot(node)){
                List<Node> children = node.getChildren();
                if (children != null) {
                    for (Node child: children) {
                        addAllNodes(child, listOfNodes);
                    }
                }
            } else {
                listOfNodes.add(node);
                List<Node> children = node.getChildren();
                if (children != null) {
                    for (Node child: children) {
                        addAllNodes(child, listOfNodes);
                    }
                }
            }
        }
    }

    public Map<Node<T>,Integer> returnAllNodesDegree(Node<T> node){
        Map<Node<T>,Integer> nodesDegrees = new HashMap<Node<T>,Integer>();;
        addAllNodesDegree(node, nodesDegrees);
        return nodesDegrees;
    }

    private void addAllNodesDegree(Node<T> node, Map<Node<T>,Integer> nodesDegrees) {
        if (node != null) {
            nodesDegrees.put(node, node.getDegree());
            List<Node> children = node.getChildren();
            if (children != null) {
                for (Node child: children) {
                    addAllNodesDegree(child, nodesDegrees);
                }
            }
        }
    }

    public Map<Node<T>,Integer> returnAllNodesHeight(Node<T> node){
        Map<Node<T>,Integer> nodesHeight = new HashMap<Node<T>,Integer>();;
        addAllNodesHeight(node, nodesHeight);
        return nodesHeight;
    }

    private void addAllNodesHeight(Node<T> node, Map<Node<T>,Integer> nodesHeight) {
        if (node != null) {
            nodesHeight.put(node, getNodeHeight(node));
            List<Node> children = node.getChildren();
            if (children != null) {
                for (Node child: children) {
                    addAllNodesHeight(child, nodesHeight);
                }
            }
        }
    }

    public Map<Node<T>,Integer> returnAllNodesDepth(Node<T> node){
        Map<Node<T>,Integer> nodesDepth = new HashMap<Node<T>,Integer>();;
        addAllNodesDepth(node, nodesDepth);
        return nodesDepth;
    }

    private void addAllNodesDepth(Node<T> node, Map<Node<T>,Integer> nodesDepth) {
        if (node != null) {
            nodesDepth.put(node, getNodeDepth(node));
            List<Node> children = node.getChildren();
            if (children != null) {
                for (Node child: children) {
                    addAllNodesDepth(child, nodesDepth);
                }
            }
        }
    }

    public Map<Node<T>,Integer> returnAllNodesLevel(Node<T> node){
        Map<Node<T>,Integer> nodesLevels = new HashMap<Node<T>,Integer>();
        Integer nodeLevel = 0;
        addAllNodesLevel(node, nodesLevels, nodeLevel);
        return nodesLevels;
    }

    private void addAllNodesLevel(Node<T> node, Map<Node<T>,Integer> nodesLevels, Integer nodeLevel) {
        if (node != null) {
            nodesLevels.put(node, nodeLevel);
            List<Node> children = node.getChildren();
            if (children != null) {
                for (Node child: children) {
                    addAllNodesLevel(child, nodesLevels, nodeLevel + 1);
                }
            }
        }
    }

    public boolean isRoot(Node<T> n) {
        return (n == this.root);
    }

    boolean isInternal(Node<T> n) {
        return (n.getChildren().size() > 0);
    }

    public ArrayList<Node<T>> returnAllLeafNodes(Node<T> node){
        ArrayList<Node<T>> leafNodes = new ArrayList<Node<T>>();
        addAllLeafNodes(node, leafNodes);
        return  leafNodes;
    }

    public void addAllLeafNodes(Node <T> node, ArrayList<Node<T>> leafNodes) {
        if (node != null) {
            if (!isInternal(node)){
                leafNodes.add(node);
                List<Node> children = node.getChildren();
                if (children != null) {
                    for (Node child: children) {
                        addAllLeafNodes(child, leafNodes);
                    }
                }
            } else {
                List<Node> children = node.getChildren();
                if (children != null) {
                    for (Node child: children) {
                        addAllLeafNodes(child, leafNodes);
                    }
                }
            }
        }
    }

    public int getNodeHeight(Node<T> node) {
        int currentHeight = -1;

        for (Node<T> filho : node.children) {
            int childHeight = getNodeHeight(filho);
            currentHeight = Math.max(currentHeight, childHeight);
        }
        currentHeight += 1;
        return currentHeight;
    }

    public int getTreeHeight() {
        int currentHeight = -1;

        for (Node<T> child : this.root.children) {
            int childHeight = getNodeHeight(child);
            currentHeight = Math.max(currentHeight, childHeight);
        }
        currentHeight += 1;
        return currentHeight;
    }

    public int getNodeDepth(Node<T> node) {
        if (isRoot(node)) {
            return 0;
        } else {
            return 1 + getNodeDepth(node.getParentNode());
        }
    }

    public String toString() {
        return this.printTree(this.root) + "";
    }

    public void transformToBinaryTree() {
        Node newRoot = encode2binary(this.root);
        this.root = newRoot;
    }

    public Node<T> encode2binary(Node node) {
        if (node == null)
            return null;

        Node<T> rootTreeNode = new Node(node.getValue());
        if (!node.children.isEmpty())
            rootTreeNode.left = encode2binary((Node) node.children.get(0));

        Node<T> currTreeNode = rootTreeNode.left;

        for (int i = 1; i < node.children.size(); ++i) {
            currTreeNode.right = encode2binary((Node) node.children.get(i));
            currTreeNode = currTreeNode.right;
        }
        return rootTreeNode;
    }

    public void printBinaryTree(Node node, String prefix)
    {
        if(node == null) return;

        System.out.println(prefix + " | " + node.getValue());
        printBinaryTree(node.left , prefix + " ");
        printBinaryTree(node.right , prefix + " ");
    }

    private String printTree(Node<T> node) {
        String result = "";
        if ((node.getChildren().size() > 0) || this.root().equals(node) ) {
            for (int i = 0; i < node.getChildren().size()-1; i++) {
                result += " ";
            }
            result += node.getValue() + "\n";
            for (int i = 0; i < node.getChildren().size(); i++) {
                result += node.getChildren().get(i) + " ";
            }
            result += "\n";
            for (int i = 0; i < node.children.size(); i++) {
                result += this.printTree((Node) node.children.get(i));
            }
        }
        return result;
    }
}