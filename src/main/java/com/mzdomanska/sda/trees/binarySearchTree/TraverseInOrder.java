package com.mzdomanska.sda.trees.binarySearchTree;

import java.util.*;

public class TraverseInOrder implements TreeTraversal {

    private <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree, List<T> listOfTreeElements) {

        if(tree.getLeft().isPresent()) {
            traverse(tree.getLeft().get(), listOfTreeElements);
        }

        listOfTreeElements.add(tree.getValue());

        if (tree.getRight().isPresent()) {
            traverse(tree.getRight().get(),listOfTreeElements);
        }

        return listOfTreeElements;
    }

    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        return traverse(tree, new ArrayList<>());
    }

}
