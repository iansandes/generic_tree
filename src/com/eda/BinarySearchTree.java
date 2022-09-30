package com.eda;

import java.util.*;



public class BinarySearchTree<T>
{


    public static <T> void buildLNROrdered(Node<T> root, Set<T> set)
    {
        if (root == null) {
            return;
        }

        buildLNROrdered(root.left, set);
        set.add(root.getValue());
        buildLNROrdered(root.right, set);
    }

    public static <T> void encode2BstLNR(Node<T> root, Iterator<T> it)
    {

        if (root == null) {
            return;
        }

        encode2BstLNR(root.left, it);
        root.setValor(it.next());
        encode2BstLNR(root.right, it);
    }

    public static <T> void convertToBST(Node<T> root)
    {

        Set<T> ordered_values = new TreeSet<>();
        buildLNROrdered(root, ordered_values);

        Iterator<T> it = ordered_values.iterator();
        encode2BstLNR(root, it);
    }

    public static <T> void deleteNodeBST(Node<T> root, int value){
        deleteNode(root, value);
    }
    public static <T> Node<T> deleteNode(Node<T> root, int value) {
        if (root == null) {
            return root;
        };
        if (value > root.getIntValue()) {
            root.right = deleteNode(root.right, value);
        } else if (value < root.getIntValue()) {
            root.left = deleteNode(root.left, value);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.setValor(turnRight(root));
                root.right = deleteNode(root.right, root.getIntValue());
            } else {
                root.setValor(turnLeft(root));
                root.left = deleteNode(root.left, root.getIntValue());
            }
        }
        return root;
    }
    public static <T> T turnRight(Node<T> root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.getValue();
    }

    public static <T> T turnLeft(Node<T> root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.getValue();
    }
}