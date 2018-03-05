package com.mzdomanska.sda.trees.binarySearchTreeTest;

import com.mzdomanska.sda.trees.binarySearchTree.BinarySearchTree;
import com.mzdomanska.sda.trees.binarySearchTree.TraversePreOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TraversePreOrderTest {

    TraversePreOrder preOrder = new TraversePreOrder();
    BinarySearchTree<Integer> root = new BinarySearchTree<>(5);

    @Test
    public void traverseForPreOrderPutsRootToTheList() throws Exception {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        List<Integer> result = preOrder.traverse(root);

        assertThat(result).containsSequence(list);

    }

    @Test
    public void traverseForPreOrderPutsLeftTreeElementsToTheList() throws Exception {

        root.insert(3);
        root.insert(2);

        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(3);
        list.add(2);

        List<Integer> result = preOrder.traverse(root);

        assertThat(result).containsSequence(list);
    }

    @Test
    public void traverseForPreOrderPutsRightTreeToTheList() throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(7);
        list.add(8);

        root.insert(7);
        root.insert(8);

        List<Integer> result = preOrder.traverse(root);

        assertThat(result).containsSequence(list);

    }

}