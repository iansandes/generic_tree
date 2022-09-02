package com.eda;

public class Main {

    public static void main(String[] args) {
        Node raiz = new Node("0045");
        Node no2 = new Node("0030");
        Node no3 = new Node("0060");
        Node no4 = new Node("0020");
        Node no5 = new Node("0040");
        Node no6 = new Node("0050");
        Node no7 = new Node("0075");
        Node no8 = new Node("0010");
        Node no9 = new Node("0025");
        Node no10 = new Node("0035");
        Node no11 = new Node("0042");
        Node no12 = new Node("0049");
        Node no13 = new Node( "0052");
        Node no14 = new Node("0070");
        Node no15 = new Node("0080");
        Node no16 = new Node("0027");

        GenericTree genericTreeTeste = new GenericTree(raiz);

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



    }

}
