package com.mzdomanska.sda.trees.time;

public interface Time extends Comparable<Time> {

    int getHours();
    int getMinutes();
    int getSeconds();
    Time copy();
    Time addHours(int hours);
    Time addMinutes(int minutes);
    Time addSeconds(int seconds);
    Time add(Time other);
    //Time subtract(Time other);
}
