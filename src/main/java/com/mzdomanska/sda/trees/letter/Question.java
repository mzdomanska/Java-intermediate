package com.mzdomanska.sda.trees.letter;

import java.util.function.Predicate;

public class Question<LetterInput, TextOutput> implements DecisionTree<LetterInput, TextOutput> {

    private Predicate<LetterInput> predicate;
    private DecisionTree<LetterInput,TextOutput> yes;
    private DecisionTree<LetterInput,TextOutput> no;

    public Question(Predicate<LetterInput> predicate) {
        this.predicate = predicate;
    }

    @Override
    public TextOutput ask(LetterInput letter) {
        if (predicate.test(letter)) {
            return yes.ask(letter);
        }
        else return no.ask(letter);
    }

    @Override
    public void yes(DecisionTree<LetterInput, TextOutput> decisionTree) {
        this.yes = decisionTree;
    }

    @Override
    public void no(DecisionTree<LetterInput, TextOutput> decisionTree) {
        this.no = decisionTree;
    }
}
