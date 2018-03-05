package com.mzdomanska.sda.trees.decisionTree;

import java.util.function.Predicate;

public class Question<Input,Output> implements DecisionTree<Input,Output> {

    private Predicate<Input> predicate;
    private DecisionTree<Input,Output> yes;
    private DecisionTree<Input,Output> no;

    public Question(Predicate<Input> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Output ask(Input input) {
        if (predicate.test(input)) {
            return yes.ask(input);
        }
        else {
            return no.ask(input);
        }

    }

    @Override
    public void setYes(DecisionTree<Input, Output> decisionTree) {
        this.yes = decisionTree;
    }

    @Override
    public void setNo(DecisionTree<Input, Output> decisionTree) {
        this.no = decisionTree;
    }
}
