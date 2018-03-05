package com.mzdomanska.sda.trees.binarySearchTree;

import java.util.Iterator;
import java.util.Optional;

public class BinarySearchTree <T extends Comparable<T>> implements Iterable<T> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    private T value;

    public BinarySearchTree(T value) {
        if (value == null)
            throw new IllegalArgumentException("Value passed to the BinarySearchTree constructor cannot be null");

        this.value = value;
    }

    public T getValue() {
        return value;
    }

    //jezeli chcemy zwrocic left to moze on byc nullem bo drzewo nie musi miec dwoch galezi
    //Optional pozwala nam ominac NullPointerException - jezeli cos moze byc nullem to zwroc optional
    //z tej wartosci, czyli pusty Optional

    public Optional<BinarySearchTree<T>> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<BinarySearchTree<T>> getRight() {
        return Optional.ofNullable(right);
    }

    public void insert(T value) {
        if (value == null)
            throw new IllegalArgumentException("Value passed to insert method cannot be null");
        if (value.compareTo(getValue()) == 0)
            throw new IllegalArgumentException("Value passed to insert method already exists in the tree: " + value);
        if (value.compareTo(getValue()) == -1) {
            if (left == null)
                left = new BinarySearchTree<>(value);
            else
                left.insert(value);
        }
        if (value.compareTo(getValue()) == 1) {
            if (right == null)
                right = new BinarySearchTree<>(value);
            else
                right.insert(value);
        }
    }

    public Optional<T> find(T value) {

        if (value == null)
            throw new IllegalArgumentException("Value passed to find method cannot be null");
        if (value.compareTo(getValue()) == 0)
            return Optional.of(value);
        else if (value.compareTo(getValue()) == -1 && left != null)
            return left.find(value);
        else if (value.compareTo(getValue()) == 1 && right != null)
            return right.find(value);

        return Optional.empty();
    }

    @Override
    public Iterator<T> iterator() {
        TreeTraversal inOrder = new TraverseInOrder();
        return inOrder.traverse(this).iterator();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(6);
        tree.insert(4);
        tree.insert(9);

        for (Integer t : tree) {
            System.out.println(t);
        }
    }
}
