package com.mzdomanska.sda.trees.binarySearchTreeTest;

import com.mzdomanska.sda.trees.binarySearchTree.BinarySearchTree;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BinarySearchTreeTest {

    private final BinarySearchTree<Integer> root = new BinarySearchTree<>(5);

    @Test
    public void throwsExceptionForNullConstrucorArgument() throws Exception {

        assertThatThrownBy(() -> new BinarySearchTree<>(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void doesNotThrowExceptionForNonNullConstructorArgument() throws Exception {

        assertThat(root.getValue()).isEqualTo(5);
    }

    @Test
    public void insertThrowsExceptionForNullArgumentValue() throws Exception {

        assertThatThrownBy(() -> root.insert(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void insertThrowsExceptionIfGivenValueAlreadyExistsInTree() throws Exception {

        assertThatThrownBy(() -> root.insert(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void lowerValueIsInsertedAsALeftChild() throws Exception {

        root.insert(4);

        assertThat(root.getLeft()).isNotEqualTo(null);

        Optional<BinarySearchTree<Integer>> leftChild = root.getLeft();

        if (leftChild.isPresent()) {
            assertThat(leftChild.get().getValue()).isEqualTo(4);
        }
    }

    @Test
    public void lowerValueIsInsertedAsLeftChildOfLeftSubtree() throws Exception {

        root.insert(4);
        root.insert(3);

        BinarySearchTree<Integer> leftSubtree = root.getLeft().get();

        assertThat(leftSubtree.getLeft().get().getValue()).isEqualTo(3);
    }

    @Test
    public void greaterValueIsInsertedAsRightChild() throws Exception {

        root.insert(7);

        assertThat(root.getRight()).isNotEqualTo(null);

        Optional<BinarySearchTree<Integer>> rightChild = root.getRight();

        if (rightChild.isPresent())
            assertThat(rightChild.get().getValue()).isEqualTo(7);
    }

    @Test
    public void greaterValueIsInsertedAsRightChildOfRightSubtree() throws Exception {

        root.insert(8);
        root.insert(12);

        BinarySearchTree<Integer> rightSubtree = root.getRight().get();

        assertThat(rightSubtree.getRight().get().getValue()).isEqualTo(12);
    }

    @Test
    public void findThrowsExceptionForNullArgumentValue() throws Exception {

        assertThatThrownBy(() -> root.find(null)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void findReturnsOptionalOfArgumentValueIfThisValueExistsInTheTree() throws Exception {

        assertThat(root.find(5)).isEqualTo(Optional.of(5));
    }

    @Test
    public void findReturnsEmptyOptionalIfArgumentValueDoesNotExistInTheTree() throws Exception {

        assertThat(root.find(4)).isEqualTo(Optional.empty());
    }

    @Test
    public void findForValueLowerThanNodesValueGoesToNodesLeftChild() throws Exception {

        root.insert(3);
        root.insert(7);

        assertThat(root.find(3)).isEqualTo(Optional.of(3));
    }

    @Test
    public void findForValueGreaterThanNodesValueGoesToNodesRightChild() throws Exception {

        root.insert(3);
        root.insert(7);

        assertThat(root.find(7)).isEqualTo(Optional.of(7));
    }



}