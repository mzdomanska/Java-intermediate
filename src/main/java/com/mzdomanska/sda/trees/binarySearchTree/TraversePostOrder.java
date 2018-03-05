package com.mzdomanska.sda.trees.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TraversePostOrder implements TreeTraversal {

    private <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree, List<T> listOfTreeElements) {

        if(tree.getLeft().isPresent()) {
            traverse(tree.getLeft().get(), listOfTreeElements);
        }

        if (tree.getRight().isPresent()) {
            traverse(tree.getRight().get(),listOfTreeElements);
        }

        listOfTreeElements.add(tree.getValue());

        return listOfTreeElements;
    }

    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        return traverse(tree, new ArrayList<>());
    }

}
