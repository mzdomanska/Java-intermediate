package com.mzdomanska.sda.trees.binarySearchTree;

import com.mzdomanska.sda.trees.binarySearchTree.BinarySearchTree;

import java.util.List;

public interface TreeTraversal {

    <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree);
}
