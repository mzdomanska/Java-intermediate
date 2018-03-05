package com.mzdomanska.sda.trees.letter;

public class Answer<LetterInput,TextOutput> implements DecisionTree<LetterInput,TextOutput> {

    private TextOutput output;

    public Answer(TextOutput output) {
        this.output = output;
    }

    @Override
    public TextOutput ask(LetterInput letter) {
        return output;
    }

    @Override
    public void yes(DecisionTree<LetterInput, TextOutput> decisionTree) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void no(DecisionTree<LetterInput, TextOutput> decisionTree) {
        throw new UnsupportedOperationException();
    }
}
