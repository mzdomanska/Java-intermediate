package com.mzdomanska.sda.trees.multithreading;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task12Test {

    private Task12And13 task12 = new Task12And13();

    @Test
    public void createSquaresListShouldPutNewListToAMapIfGivenKeyIsNotInAMap() {

        int key = 5;
        List<Integer> list = task12.createSquaresList(key);
        List<Integer> listInAMap = task12.getCache().get(key);

        assertThat(listInAMap).isSameAs(list);

    }

    @Test
    public void createSquaresListShouldReturnListFromMapIfGivenKeyIsInAMap() {

        int key = 6;
        List<Integer> listToMap = task12.createSquaresList(key);

        assertThat(listToMap).isEqualTo(task12.getCache().get(key));

    }
}
