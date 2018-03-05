package com.mzdomanska.sda.trees.decisionTree;

public interface DecisionTree<Input, Output> {

    public Output ask(Input input);

    void setYes(DecisionTree<Input, Output> decisionTree);

    void setNo(DecisionTree<Input, Output> decisionTree);

}
