package com.eda;

import Exceptions.DuplicatedNodeException;

public class Main {

    public static void main(String[] args) throws DuplicatedNodeException {
//        /*Node raiz = new Node("0045");
//        Node no2 = new Node("0030");
//        Node no3 = new Node("0060");
//        Node no4 = new Node("0020");
//        Node no5 = new Node("0040");
//        Node no6 = new Node("0050");
//        Node no7 = new Node("0075");
//        Node no8 = new Node("0010");
//        Node no9 = new Node("0025");
//        Node no10 = new Node("0035");
//        Node no11 = new Node("0042");
//        Node no12 = new Node("0049");
//        Node no13 = new Node( "0052");
//        Node no14 = new Node("0070");
//        Node no15 = new Node("0080");
//        Node no16 = new Node("0027"); */


        Node raiz = new Node(45);
        Node no2 = new Node(30);
        Node no3 = new Node(60);
        Node no4 = new Node(20);
        Node no5 = new Node(40);
        Node no6 = new Node(50);
        Node no7 = new Node(75);
        Node no8 = new Node(10);
        Node no9 = new Node(25);
        Node no10 = new Node(35);
        Node no11 = new Node(42);
        Node no12 = new Node(49);
        Node no13 = new Node(52);
        Node no14 = new Node(70);
        Node no15 = new Node(80);
        Node no16 = new Node(27);
//
//        Node raiz = new Node("A");
//        Node no2 = new Node("B");
//        Node no3 = new Node("C");
//        Node no4 = new Node("D");
//        Node no5 = new Node("E");
//        Node no6 = new Node("F");
//        Node no7 = new Node("G");
//        Node no8 = new Node("H");
//        Node no9 = new Node("I");
//        Node no10 = new Node("J");
//        Node no11 = new Node("K");
//
//


        raiz.addChild(no2);
        raiz.addChild(no3);
        no2.addChild(no4);
        no2.addChild(no5);
        no3.addChild(no6);
        no3.addChild(no7);
        no4.addChild(no8);
        no4.addChild(no9);
        no5.addChild(no10);
        no5.addChild(no11);
        no6.addChild(no12);
        no6.addChild(no13);
        no7.addChild(no14);
        no7.addChild(no15);
        no9.addChild(no16);

        GenericTree genericTreeTeste = new GenericTree(raiz);
//
//        raiz.addChild(no2);
//        raiz.addChild(no3);
//        raiz.addChild(no4);
//        no2.addChild(no5);
//        no3.addChild(no6);
//        no3.addChild(no7);
//        no3.addChild(no8);
//        no4.addChild(no9);
//        no4.addChild(no10);
//        no10.addChild(no11);
//
//
        System.out.print("Raiz: ");
        System.out.println(genericTreeTeste.getRoot().getValue());

        System.out.print("Nós: ");
        System.out.println(genericTreeTeste.returnAllNodes(raiz));

        System.out.print("Nós folhas: ");
        System.out.println(genericTreeTeste.returnAllLeafNodes(raiz));

        System.out.println("Árvore: ");
        System.out.println(genericTreeTeste);

        System.out.print("Graus de todos os nós: ");
        System.out.println(genericTreeTeste.returnAllNodesDegree(raiz));

        System.out.print("Altura de todos os nós: ");
        System.out.println(genericTreeTeste.returnAllNodesHeight(raiz));

        System.out.print("Profundidade de todos os nós: ");
        System.out.println(genericTreeTeste.returnAllNodesDepth(raiz));

        System.out.print("Nível de todos os nós: ");
        System.out.println(genericTreeTeste.returnAllNodesLevel(raiz));


        genericTreeTeste.transformToBinaryTree();

        System.out.println("Árvore Binária");
        genericTreeTeste.printBinaryTree(genericTreeTeste.getRoot(), " ");


        System.out.println("Árvore Binária de Busca");
        BinarySearchTree.convertToBST(genericTreeTeste.getRoot());

        genericTreeTeste.printBinaryTree(genericTreeTeste.getRoot(), " ");

        System.out.println("Nó deletado");
        BinarySearchTree.deleteNodeBST(genericTreeTeste.getRoot(), 80);

        genericTreeTeste.printBinaryTree(genericTreeTeste.getRoot(), " ");
    }
}