package com.mzdomanska.sda.trees.binarySearchTreeTest;

import com.mzdomanska.sda.trees.binarySearchTree.BinarySearchTree;
import com.mzdomanska.sda.trees.binarySearchTree.TraverseInOrder;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class TraverseInOrderTest {

    TraverseInOrder inOrder = new TraverseInOrder();
    BinarySearchTree<Integer> root = new BinarySearchTree<>(5);

    @Test
    public void traverseForInOrderPutsLeftTreeElementsToTheList() throws Exception {

        root.insert(4);
        root.insert(3);

        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(4);

        List<Integer> result = inOrder.traverse(root);

        assertThat(result).containsSequence(list);
    }

    @Test
    public void traverseForInOrderPutsRootToTheList() throws Exception {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        List<Integer> result = inOrder.traverse(root);

        assertThat(result).containsSequence(list);

    }

    @Test
    public void traverseForInOrderPutsRightTreeToTheList() throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(7);
        list.add(15);

        root.insert(7);
        root.insert(15);

        List<Integer> result = inOrder.traverse(root);

        assertThat(result).containsSequence(list);

    }
}