package com.mzdomanska.sda.trees.binarySearchTree;

import java.util.*;

public class BreadthFirst <T extends Comparable<T>> implements TreeTraversal {

    private <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree, List<T> listOfTreeElements) {

        Queue<BinarySearchTree> queue = new LinkedList<>();

        queue.add(tree);

        listOfTreeElements.add(tree.getValue());

        while (!queue.isEmpty()) {


        }



        return listOfTreeElements;
    }

    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        return traverse(tree, new ArrayList<>());
    }
}
