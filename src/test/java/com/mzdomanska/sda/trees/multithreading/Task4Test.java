package com.mzdomanska.sda.trees.multithreading;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4Test {

    Task4And5 task4 = new Task4And5();

    @Test
    public void changeList() throws Exception {

        List<Double> list = new ArrayList<>();
        list.add(4.0);
        list.add(36.0);
        list.add(4.0);
        list.add(9.0);

        List<Double> listBeforeChanges = Arrays.asList(2.0,6.0,16.0,81.0);
        List<Double> result = task4.changeList(listBeforeChanges);

        Assertions.assertThat(result).isEqualTo(list);

    }

}