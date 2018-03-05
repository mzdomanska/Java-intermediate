package com.mzdomanska.sda.trees.binarySearchTreeTest;

import com.mzdomanska.sda.trees.binarySearchTree.BinarySearchTree;
import com.mzdomanska.sda.trees.binarySearchTree.TraversePostOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TraversePostOrderTest {

    TraversePostOrder postOrder = new TraversePostOrder();
    BinarySearchTree<Integer> root = new BinarySearchTree<>(5);

    @Test
    public void traverseForPostOrderPutsLeftTreeElementsToTheList() throws Exception {

        root.insert(3);
        root.insert(2);

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(5);

        List<Integer> result = postOrder.traverse(root);

        assertThat(result).containsSequence(list);
    }

    @Test
    public void traverseForPreOrderPutsRightTreeToTheList() throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(8);
        list.add(7);
        list.add(5);

        root.insert(7);
        root.insert(8);

        List<Integer> result = postOrder.traverse(root);

        assertThat(result).containsSequence(list);

    }

    @Test
    public void traverseForPreOrderPutsRootToTheList() throws Exception {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        List<Integer> result = postOrder.traverse(root);

        assertThat(result).containsSequence(list);

    }



}