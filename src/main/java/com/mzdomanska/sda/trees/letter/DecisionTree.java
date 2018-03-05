package com.mzdomanska.sda.trees.letter;

public interface DecisionTree<LetterInput, TextOutput> {

    public TextOutput ask(LetterInput letter);
    void yes(DecisionTree<LetterInput, TextOutput> decisionTree);
    void no(DecisionTree<LetterInput,TextOutput> decisionTree);


}
