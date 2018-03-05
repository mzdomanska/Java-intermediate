package com.mzdomanska.sda.trees.decisionTree;

public class Answer<Input,Output> implements DecisionTree<Input,Output> {

    private Output output;

    public Answer(Output output) {
        this.output = output;
    }

    @Override
    public Output ask(Input input) {
        return output;
    }

    @Override
    public void setYes(DecisionTree<Input, Output> decisionTree) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNo(DecisionTree<Input, Output> decisionTree) {
        throw new UnsupportedOperationException();
    }
}
